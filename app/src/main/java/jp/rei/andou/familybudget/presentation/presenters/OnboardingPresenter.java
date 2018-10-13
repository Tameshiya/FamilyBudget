package jp.rei.andou.familybudget.presentation.presenters;

import javax.inject.Inject;

import jp.rei.andou.familybudget.domain.onboarding.OnboardingInteractor;
import jp.rei.andou.familybudget.presentation.router.FragmentNavigator;
import jp.rei.andou.familybudget.presentation.views.OnboardingContract;
import jp.rei.andou.familybudget.presentation.views.WelcomeOnboarding;

public class OnboardingPresenter extends OnboardingContract.OnboardingPresenter {

    private FragmentNavigator navigator;
    private final OnboardingInteractor interactor;

    @Inject
    public OnboardingPresenter(OnboardingInteractor interactor, FragmentNavigator navigator) {
        this.interactor = interactor;
        this.navigator = navigator;
        navigator.newScreen(new WelcomeOnboarding()/*WelcomeFragment()*/);
//        navigator.newScreen(new Fragment()/*WelcomeFragment()*/);
    }

    @Override
    public void toNextStep() {
//        if (interactor.validateFamily())
    }
}
