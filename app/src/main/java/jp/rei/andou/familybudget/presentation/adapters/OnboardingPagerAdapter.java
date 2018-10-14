package jp.rei.andou.familybudget.presentation.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import javax.inject.Inject;

import jp.rei.andou.familybudget.presentation.views.onboarding.OnboardingContract.OnboardingPagerAdapterPresenter;


public class OnboardingPagerAdapter extends FragmentPagerAdapter {

    private final OnboardingPagerAdapterPresenter presenter;

    @Inject
    public OnboardingPagerAdapter(FragmentManager fm, OnboardingPagerAdapterPresenter presenter) {
        super(fm);
        this.presenter = presenter;
    }

    @Override
    public Fragment getItem(int position) {
        return presenter.getItemOnPosition(position);
    }

    @Override
    public int getCount() {
        return presenter.getPagesCount();
    }
}
