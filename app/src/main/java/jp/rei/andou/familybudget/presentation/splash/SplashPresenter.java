package jp.rei.andou.familybudget.presentation.splash;

import javax.inject.Inject;

import jp.rei.andou.familybudget.domain.splash.SplashInteractor;
import jp.rei.andou.familybudget.presentation.main.MainActivity;
import jp.rei.andou.familybudget.presentation.onboarding.OnboardingActivity;
import jp.rei.andou.familybudget.presentation.router.ActivityNavigator;

public class SplashPresenter extends SplashContract.SplashPresenterContract {

    private final ActivityNavigator navigator;
    private final SplashInteractor interactor;

    @Inject
    public SplashPresenter(ActivityNavigator activityNavigator, SplashInteractor interactor) {
        this.navigator = activityNavigator;
        this.interactor = interactor;
    }

    @Override
    void onReadyToStart() {
        if (interactor.hasProfileActive()) {
            navigator.replaceWith(MainActivity.class);
        } else {
            navigator.replaceWith(OnboardingActivity.class);
        }
    }
}
