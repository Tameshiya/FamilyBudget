package jp.rei.andou.familybudget.di.modules;

import dagger.Module;
import dagger.Provides;
import jp.rei.andou.familybudget.di.scopes.SplashScreenScope;
import jp.rei.andou.familybudget.domain.splash.DatabaseSplashInteractor;
import jp.rei.andou.familybudget.presentation.router.ActivityNavigator;
import jp.rei.andou.familybudget.presentation.splash.SplashPresenter;

@Module
public class SplashModule {

    @SplashScreenScope
    @Provides
    public SplashPresenter provideSomeInt(ActivityNavigator navigator, DatabaseSplashInteractor interactor) {
        return new SplashPresenter(navigator, interactor);
    }

}
