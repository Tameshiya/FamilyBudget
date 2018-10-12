package jp.rei.andou.familybudget.presentation.presenters;

import javax.inject.Inject;

import jp.rei.andou.familybudget.domain.splash.SplashInteractor;
import jp.rei.andou.familybudget.presentation.router.ActivityNavigator;
import jp.rei.andou.familybudget.presentation.views.MainActivity;
import jp.rei.andou.familybudget.presentation.views.SplashContract;

public class SplashPresenter extends SplashContract.SplashPresenter {

    ActivityNavigator navigator;
    private final SplashInteractor interactor;

    @Inject
    public SplashPresenter(SplashInteractor interactor, ActivityNavigator navigator) {
        this.interactor = interactor;
        this.navigator = navigator;
    }

    @Override
    public void onReadyToStart() {
        if (interactor.hasProfileActive()) {
            navigator.replaceWith(MainActivity.class);
        } else {
//            navigator.replaceWith(OnboardingActivity.class);
        }
    }

}
