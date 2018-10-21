package jp.rei.andou.familybudget.presentation.presenters;

import io.reactivex.Observable;
import jp.rei.andou.familybudget.domain.onboarding.OnboardingInteractor;

import static jp.rei.andou.familybudget.presentation.views.onboarding.IntroducingOnboardingContract.IntroducingPresenter;


public class IntroducingPresenterImpl extends IntroducingPresenter {

    private final OnboardingInteractor interactor;

    public IntroducingPresenterImpl(OnboardingInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void listenFamilyName(Observable<String> familyName) {

    }

    @Override
    public void listenDeposit(Observable<String> deposit) {

    }
}
