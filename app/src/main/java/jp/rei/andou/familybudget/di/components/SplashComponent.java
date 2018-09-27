package jp.rei.andou.familybudget.di.components;

import dagger.Subcomponent;
import jp.rei.andou.familybudget.di.modules.SplashModule;
import jp.rei.andou.familybudget.di.scopes.SplashScreenScope;
import jp.rei.andou.familybudget.presentation.splash.SplashActivity;

@Subcomponent(modules = SplashModule.class)
@SplashScreenScope
public interface SplashComponent {

    void inject(SplashActivity activity);

}
