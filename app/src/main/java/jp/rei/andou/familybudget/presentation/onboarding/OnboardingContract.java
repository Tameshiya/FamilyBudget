package jp.rei.andou.familybudget.presentation.onboarding;

import jp.rei.andou.familybudget.presentation.general.BaseView;
import jp.rei.andou.familybudget.presentation.general.Presenter;

public interface OnboardingContract {

    interface OnboardingView extends BaseView {
        void onNextPressed();
    }

    abstract class OnboardingPresenterContract extends Presenter<OnboardingView> {
        abstract void toNextStep();

    }

}
