package jp.rei.andou.familybudget.presentation.presenters;

import javax.inject.Inject;

import dagger.Lazy;
import jp.rei.andou.familybudget.domain.splash.SplashInteractor;
import jp.rei.andou.familybudget.presentation.router.ActivityNavigator;
import jp.rei.andou.familybudget.presentation.views.MainActivity;
import jp.rei.andou.familybudget.presentation.views.OnboardingActivity;
import jp.rei.andou.familybudget.presentation.views.SplashContract;

public class SplashPresenter extends SplashContract.SplashPresenter {

    @Inject
    Lazy<ActivityNavigator> navigator;
    private final SplashInteractor interactor;

    @Inject
    public SplashPresenter(SplashInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void onReadyToStart() {
        if (interactor.hasProfileActive()) {
            navigator.get().replaceWith(MainActivity.class);
        } else {
            navigator.get().replaceWith(OnboardingActivity.class);
        }
    }
}
