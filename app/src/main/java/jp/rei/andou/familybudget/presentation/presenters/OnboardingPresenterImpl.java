package jp.rei.andou.familybudget.presentation.presenters;

import javax.inject.Inject;

import jp.rei.andou.familybudget.domain.onboarding.OnboardingInteractor;
import jp.rei.andou.familybudget.presentation.adapters.OnboardingPagerAdapter;
import jp.rei.andou.familybudget.presentation.router.FragmentNavigator;

import static jp.rei.andou.familybudget.presentation.views.onboarding.OnboardingContract.OnboardingView;

//todo Refactor to "SmartRouter" implementation instead of this SUPER-presenter implementation 
public class OnboardingPresenterImpl extends OnboardingPresenter {

    private final FragmentNavigator navigator;
    private final OnboardingInteractor interactor;
    private final OnboardingPagerAdapter pagerAdapter;

    @Inject
    public OnboardingPresenterImpl(OnboardingInteractor interactor, FragmentNavigator navigator,
                                   OnboardingPagerAdapter pagerAdapter) {
        //todo if constructor parameters number become greater than 3 it's will be necessary to refactoring for composited parameters
        this.interactor = interactor;
        this.navigator = navigator;
        this.pagerAdapter = pagerAdapter;
    }

    @Override
    void onViewBound(OnboardingView view) {
        view.setupAdapter(pagerAdapter);
    }

    @Override
    public void toNextStep() {
//        if (interactor.validateFamily())
    }
}
