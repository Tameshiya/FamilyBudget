package jp.rei.andou.familybudget.presentation.presenters;

import android.util.Log;
import android.widget.Toast;

import com.jakewharton.rxrelay2.PublishRelay;

import javax.inject.Inject;

import io.reactivex.Observable;
import jp.rei.andou.familybudget.R;
import jp.rei.andou.familybudget.domain.onboarding.OnboardingInteractor;
import jp.rei.andou.familybudget.presentation.model.OnboardingEvent;
import jp.rei.andou.familybudget.presentation.router.ActivityNavigator;
import jp.rei.andou.familybudget.presentation.views.MainActivity;

import static jp.rei.andou.familybudget.presentation.views.onboarding.IntroducingOnboardingContract.IntroducingPresenter;


public class IntroducingPresenterImpl extends IntroducingPresenter {

    private final OnboardingInteractor interactor;
    private final ActivityNavigator navigator;
    private final PublishRelay<Boolean> familyNameEvents = PublishRelay.create();
    private final PublishRelay<Boolean> familyDepositEvents = PublishRelay.create();
    private final PublishRelay<OnboardingEvent> onboardingEvents;

    @Inject
    public IntroducingPresenterImpl(OnboardingInteractor interactor, ActivityNavigator activityNavigator,
                                    PublishRelay<OnboardingEvent> onboardingEvents) {
        this.interactor = interactor;
        this.navigator = activityNavigator;
        this.onboardingEvents = onboardingEvents;
        init();
    }

    private void init() {
        //todo remove this global button disability
        onboardingEvents.accept(OnboardingEvent.DISABLE_NEXT_BUTTON);
        //todo 以下のコードをここにするかインタラクターに移るかについて少し考え直すようにK
        Observable<Boolean> nextButtonState = Observable.combineLatest(
                familyNameEvents,
                familyDepositEvents,
                (name, deposit) -> name && deposit
        ).share();
        nextButtonState.filter(isEnabled -> isEnabled)
                       .subscribe(state -> {
                                   onboardingEvents.accept(OnboardingEvent.ENABLE_NEXT_BUTTON);
                                   getViewOrThrow().showInputVerifiedStamp();
                       }, throwable -> Log.e("Verify failed: ", throwable.getMessage()));
        nextButtonState.filter(isEnabled -> !isEnabled)
                       .subscribe(state -> {
                           onboardingEvents.accept(OnboardingEvent.DISABLE_NEXT_BUTTON);
                           getViewOrThrow().showInvalidInputStamp();
                       }, throwable -> Log.e("Verify failed: ", throwable.getMessage()));

        onboardingEvents.filter(event -> event.equals(OnboardingEvent.LOGIN))
                        .subscribe(
                                (event) -> login(
                                        getViewOrThrow().getInputtedFamilyName(),
                                        getViewOrThrow().getInputtedFamilyDeposit()
                                ),
                                throwable -> getViewOrThrow().showToast(
                                        R.string.loginAttemptIsFailed,
                                        Toast.LENGTH_LONG
                                )
                        );
    }

    @Override
    public void listenFamilyName(Observable<CharSequence> familyNameListener) {
        familyNameListener.subscribe(
                charSequence -> {
                    if (interactor.validateFamily(charSequence)) {
                        familyNameEvents.accept(true);
                        getViewOrThrow().hideFamilyNameInputError();
                    } else {
                        familyNameEvents.accept(false);
                        getViewOrThrow().showFamilyNameInputError("Valid family name is longer that 5 alph. chars");
                    }
                },
                throwable -> {}
        );
    }

    @Override
    public void listenDeposit(Observable<CharSequence> deposit) {
        deposit.subscribe(
                charSequence -> {
                    if (interactor.validateDeposit(charSequence)) {
                        familyDepositEvents.accept(true);
                        getViewOrThrow().hideFamilyDepositInputError();
                    } else {
                        familyDepositEvents.accept(false);
                        getViewOrThrow().showFamilyDepositInputError("Valid deposit is greater that 10000 value");
                    }
                },
                throwable -> {}
        );
    }

    @Override
    public void login(String familyName, long deposit) {
        interactor.register(familyName, deposit)
                  .flatMapCompletable(interactor::saveFamilyReference)
                  .subscribe(() -> {
                      // TODO: 29.10.2018 save in sharedPreferences
                      navigator.replaceWith(MainActivity.class);
                  }, (throwable -> {
                      getViewOrThrow().showToast(R.string.loginAttemptIsFailed, Toast.LENGTH_LONG);
                  }));
    }
}
