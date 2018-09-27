package jp.rei.andou.familybudget.presentation.onboarding;

import javax.inject.Inject;

import jp.rei.andou.familybudget.domain.onboarding.OnboardingInteractor;
import jp.rei.andou.familybudget.presentation.router.FragmentNavigator;

public class OnboardingPresenter extends OnboardingContract.OnboardingPresenterContract {

    private final FragmentNavigator navigator;
    private final OnboardingInteractor interactor;

    @Inject
    public OnboardingPresenter(FragmentNavigator navigator, OnboardingInteractor interactor) {
        this.navigator = navigator;
        this.interactor = interactor;
    }

    @Override
    void toNextStep() {
//        if (interactor.validateFamily())
    }
}
