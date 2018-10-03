package jp.rei.andou.familybudget.presentation.splash;


import java.lang.ref.WeakReference;

import javax.inject.Inject;

import jp.rei.andou.familybudget.di.components.AppComponent;
import jp.rei.andou.familybudget.di.components.SplashComponent;
import jp.rei.andou.familybudget.di.modules.SplashModule;
import jp.rei.andou.familybudget.di.scopes.SplashScreenScope;
import jp.rei.andou.familybudget.presentation.general.ComponentInjector;
import jp.rei.andou.familybudget.presentation.views.SplashActivity;

public class SplashComponentManager implements ComponentInjector<SplashActivity> {

    private final AppComponent appComponent;
    /**
     * For auto-cleaning component reference on Activity is finished
     * {@link WeakReference} For avoiding "scope singletonfying" by keeping strong reference
     */
    @SplashScreenScope
    WeakReference<SplashComponent> splashComponentReference;

    @Inject
    public SplashComponentManager(AppComponent appComponent) {
        this.appComponent = appComponent;
    }

    public void inject(SplashActivity splashActivity) {
        SplashComponent splashComponent = splashComponentReference.get();
        if (splashActivity == null) {
            splashComponent = appComponent.plus(new SplashModule());
            splashComponentReference = new WeakReference<>(splashComponent);
        }
        splashComponent.inject(splashActivity);
    }

}
