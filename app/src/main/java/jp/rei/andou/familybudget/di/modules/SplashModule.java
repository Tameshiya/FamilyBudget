package jp.rei.andou.familybudget.di.modules;

import dagger.Module;
import dagger.Provides;
import jp.rei.andou.familybudget.di.scopes.SplashScreenScope;
import jp.rei.andou.familybudget.domain.splash.DatabaseSplashInteractor;
import jp.rei.andou.familybudget.domain.splash.SplashInteractor;
import jp.rei.andou.familybudget.presentation.splash.SplashPresenter;

@Module
public class SplashModule {

    @SplashScreenScope
    @Provides
    public SplashPresenter provideSplashPresenter(/*ActivityNavigator navigator,*/
                                                        SplashInteractor interactor) {
        return new SplashPresenter(null, interactor);
    }

    @SplashScreenScope
    @Provides
    public SplashInteractor provideSplashInteractor() {
        return new DatabaseSplashInteractor();
    }

}
