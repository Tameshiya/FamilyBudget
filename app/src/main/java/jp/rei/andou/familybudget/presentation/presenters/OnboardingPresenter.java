package jp.rei.andou.familybudget.presentation.presenters;

import jp.rei.andou.familybudget.presentation.views.onboarding.OnboardingContract;

public abstract class OnboardingPresenter extends Presenter<OnboardingContract.OnboardingView> {
    public abstract void toNextStep();
}
