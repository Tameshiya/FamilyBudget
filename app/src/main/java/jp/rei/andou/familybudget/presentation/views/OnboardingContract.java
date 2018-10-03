package jp.rei.andou.familybudget.presentation.views;

import jp.rei.andou.familybudget.presentation.general.BaseView;
import jp.rei.andou.familybudget.presentation.presenters.Presenter;

public interface OnboardingContract {

    interface OnboardingView extends BaseView {
        void onNextPressed();
    }

    abstract class OnboardingPresenter extends Presenter<OnboardingView> {
        public abstract void toNextStep();
    }

}
