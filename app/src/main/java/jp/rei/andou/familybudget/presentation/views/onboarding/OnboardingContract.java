package jp.rei.andou.familybudget.presentation.views.onboarding;

import android.support.v4.app.Fragment;

import jp.rei.andou.familybudget.presentation.adapters.OnboardingPagerAdapter;
import jp.rei.andou.familybudget.presentation.general.BaseView;

public interface OnboardingContract {

    interface OnboardingView extends BaseView {
        void onNextPressed();
        void setupAdapter(OnboardingPagerAdapter adapter);
        void enableNextButton(boolean enable);
    }

    abstract class OnboardingPagerAdapterPresenter {

        public abstract Fragment getItemOnPosition(int position);
        public abstract int getPagesCount();
    }

}
