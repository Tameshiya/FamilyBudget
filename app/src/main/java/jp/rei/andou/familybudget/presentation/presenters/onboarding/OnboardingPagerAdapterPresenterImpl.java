package jp.rei.andou.familybudget.presentation.presenters.onboarding;

import android.support.v4.app.Fragment;

import java.util.List;

import jp.rei.andou.familybudget.presentation.views.onboarding.OnboardingContract.OnboardingPagerAdapterPresenter;

public class OnboardingPagerAdapterPresenterImpl extends OnboardingPagerAdapterPresenter {

    private final List<Fragment> fragments;

    public OnboardingPagerAdapterPresenterImpl(List<Fragment> fragments) {
        this.fragments = fragments;
    }

    @Override
    public Fragment getItemOnPosition(int position) {
        return fragments.get(position);
    }

    @Override
    public int getPagesCount() {
        return fragments.size();
    }
}
