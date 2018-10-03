package jp.rei.andou.familybudget.di.modules;

import dagger.Module;
import dagger.Provides;
import jp.rei.andou.familybudget.di.scopes.SplashScreenScope;
import jp.rei.andou.familybudget.domain.splash.DatabaseSplashInteractor;
import jp.rei.andou.familybudget.domain.splash.SplashInteractor;
import jp.rei.andou.familybudget.presentation.presenters.SplashPresenter;
import jp.rei.andou.familybudget.presentation.views.SplashContract;

@Module
public class SplashModule {

    @SplashScreenScope
    @Provides
    public SplashContract.SplashPresenter provideSplashPresenter(SplashInteractor interactor) {
        return new SplashPresenter(interactor);
    }

    @SplashScreenScope
    @Provides
    public SplashInteractor provideSplashInteractor() {
        return new DatabaseSplashInteractor();
    }

}
