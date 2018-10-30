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
        Observable.combineLatest(
                familyNameEvents,
                familyDepositEvents,
                (name, deposit) -> name && deposit
        ).subscribe(
                event -> {
                    if (event) {
                        onboardingEvents.accept(OnboardingEvent.ENABLE_NEXT_BUTTON);
                        getViewOrThrow().showInputVerifiedStamp();

                    } else {
                        onboardingEvents.accept(OnboardingEvent.DISABLE_NEXT_BUTTON);
                        getViewOrThrow().showInvalidInputStamp();
                    }
                },
                throwable -> Log.e("Verify", throwable.getMessage())
        );
        onboardingEvents.filter(event -> event.equals(OnboardingEvent.NEXT))
                        .subscribe((event) -> login(
                                    getViewOrThrow().getInputtedFamilyName(),
                                    getViewOrThrow().getInputtedFamilyDeposit()
                                )
                        );
    }

    @Override
    public void listenFamilyName(Observable<CharSequence> familyNameListener) {
        familyNameListener.subscribe(
                charSequence -> {
                    if (interactor.validateFamily(charSequence)) {
                        familyNameEvents.accept(true);
                    } else {
                        familyNameEvents.accept(false);
                        // TODO: 29.10.2018  disable next button
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
                    } else {
                        familyDepositEvents.accept(false);
                        // TODO: 29.10.2018  disable next button
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
