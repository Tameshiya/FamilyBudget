package jp.rei.andou.familybudget.presentation.general;

import javax.inject.Inject;

import jp.rei.andou.familybudget.di.components.AppComponent;
import jp.rei.andou.familybudget.di.components.SplashComponent;
import jp.rei.andou.familybudget.di.modules.SplashModule;
import jp.rei.andou.familybudget.presentation.views.SplashActivity;

public class SplashComponentHandler {

    private final AppComponent appComponent;
    private SplashComponent splashComponent;

    @Inject
    public SplashComponentHandler(AppComponent appComponent) {
        this.appComponent = appComponent;
    }

    public void inject(SplashActivity splashActivity) {
        splashComponent = appComponent.plus(new SplashModule());
        splashComponent.inject(splashActivity);
    }

    public void destroyComponent(SplashActivity splashActivity) {
        splashComponent = null;
    }
}
