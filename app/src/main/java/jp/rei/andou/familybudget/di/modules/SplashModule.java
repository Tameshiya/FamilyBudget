package jp.rei.andou.familybudget.di.modules;

import dagger.Module;
import dagger.Provides;
import jp.rei.andou.familybudget.di.scopes.SplashScreenScope;
import jp.rei.andou.familybudget.domain.splash.DatabaseSplashInteractor;
import jp.rei.andou.familybudget.domain.splash.SplashInteractor;

@Module
public class SplashModule {

/*    @SplashScreenScope
    @Provides
    public SplashContract.SplashPresenter provideSplashPresenter(SplashPresenter presenter) {
        return presenter;
    }*/

    @SplashScreenScope
    @Provides
    public SplashInteractor provideSplashInteractor() {
        return new DatabaseSplashInteractor();
    }

}
