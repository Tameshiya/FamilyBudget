package jp.rei.andou.familybudget.presentation.presenters;

import javax.inject.Inject;

import dagger.Lazy;
import jp.rei.andou.familybudget.domain.onboarding.OnboardingInteractor;
import jp.rei.andou.familybudget.presentation.router.FragmentNavigator;
import jp.rei.andou.familybudget.presentation.views.OnboardingContract;

public class OnboardingPresenter extends OnboardingContract.OnboardingPresenter {

    private Lazy<FragmentNavigator> navigator;
    private final OnboardingInteractor interactor;

    @Inject
    public OnboardingPresenter(OnboardingInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void toNextStep() {
//        if (interactor.validateFamily())
    }
}
