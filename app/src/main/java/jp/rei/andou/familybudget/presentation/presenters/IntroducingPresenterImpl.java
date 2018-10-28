package jp.rei.andou.familybudget.presentation.presenters;

import android.widget.Toast;

import com.jakewharton.rxrelay2.PublishRelay;

import javax.inject.Inject;

import io.reactivex.Observable;
import jp.rei.andou.familybudget.R;
import jp.rei.andou.familybudget.domain.onboarding.OnboardingInteractor;
import jp.rei.andou.familybudget.presentation.router.ActivityNavigator;
import jp.rei.andou.familybudget.presentation.views.MainActivity;

import static jp.rei.andou.familybudget.presentation.views.onboarding.IntroducingOnboardingContract.IntroducingPresenter;


public class IntroducingPresenterImpl extends IntroducingPresenter {

    private final OnboardingInteractor interactor;
    private final ActivityNavigator navigator;
    private final PublishRelay<Integer> validEvents = PublishRelay.create();

    @Inject
    public IntroducingPresenterImpl(OnboardingInteractor interactor, ActivityNavigator activityNavigator) {
        this.interactor = interactor;
        this.navigator = activityNavigator;
        validEvents.buffer(2)
                   .subscribe(
                           fieldsIds -> {
                               if (!fieldsIds.get(0).equals(fieldsIds.get(1))) {
                                   getViewOrThrow().showInputVerifiedStamp();
                               }
                           }, throwable -> {}
                   );
    }

    @Override
    public void listenFamilyName(Observable<CharSequence> familyNameListener) {
        familyNameListener.subscribe(
                charSequence -> {
                    if (interactor.validateFamily(charSequence)) {
                        validEvents.accept(1);
                    } else {
                        // TODO: 29.10.2018  disable next button
                        getViewOrThrow().hideAnyStamp();
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
                        validEvents.accept(2);
                    } else {
                        getViewOrThrow().hideAnyStamp();
                        // TODO: 29.10.2018  disable next button
                    }
                },
                throwable -> {}
        );
    }

    @Override
    public void login(String familyName, long deposit) {
        interactor.register(familyName, deposit)
                  .subscribe((accountId) -> {
                      // TODO: 29.10.2018 save in sharedPreferences
                      navigator.replaceWith(MainActivity.class);
                  }, (throwable -> {
                      getViewOrThrow().showToast(R.string.loginAttemptIsFailed, Toast.LENGTH_LONG);
                  }));
    }
}
