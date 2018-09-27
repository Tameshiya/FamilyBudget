package jp.rei.andou.familybudget.presentation.general;

import java.lang.ref.WeakReference;

import javax.inject.Inject;
import javax.inject.Singleton;

import jp.rei.andou.familybudget.di.components.AppComponent;
import jp.rei.andou.familybudget.di.components.MainComponent;
import jp.rei.andou.familybudget.di.components.PaymentsComponent;
import jp.rei.andou.familybudget.di.components.SplashComponent;
import jp.rei.andou.familybudget.di.modules.MainModule;
import jp.rei.andou.familybudget.di.modules.PaymentsModule;
import jp.rei.andou.familybudget.di.modules.SplashModule;
import jp.rei.andou.familybudget.di.scopes.PaymentsScope;
import jp.rei.andou.familybudget.di.scopes.SplashScreenScope;
import jp.rei.andou.familybudget.presentation.main.MainActivity;
import jp.rei.andou.familybudget.presentation.onboarding.OnboardingActivity;
import jp.rei.andou.familybudget.presentation.payments.PaymentsFragment;
import jp.rei.andou.familybudget.presentation.splash.SplashActivity;

// TODO: Decouple this large manager class to many small or something like decoupled class
// TODO: In this way there is possibility to store componentsManagers in Map with activity as key and uniform interface as value
public class ComponentsManager {

    private final AppComponent appComponent;
    @Singleton
    private MainComponent containerComponent;
    /**
     * For avoiding "scope singletonfying" by keeping strong reference
     */
    @PaymentsScope
    private WeakReference<PaymentsComponent> paymentsComponentReference;
    /**
     * For auto-cleaning component reference on Activity is finished
     * {@link WeakReference} For avoiding "scope singletonfying" by keeping strong reference
     */
    @SplashScreenScope
    private WeakReference<SplashComponent> splashComponentReference;

    @Inject
    public ComponentsManager(AppComponent appComponent) {
        this.appComponent = appComponent;
    }

    private <T> WeakReference<T> updateComponentIfNeeded(WeakReference<T> reference, T value) {
        if (reference == null || reference.get() == null) {
            reference = new WeakReference<>(value);
        }
        return reference;
    }

    public void inject(MainActivity mainActivity) {
        if (containerComponent == null) {
            containerComponent = appComponent.plus(new MainModule());
            containerComponent.inject(mainActivity);
        }
    }

    // TODO: Do refactor this same type copy-paste-like methods
    public void inject(SplashActivity splashActivity) {
        SplashComponent splashComponent = appComponent.plus(new SplashModule());
        splashComponentReference = updateComponentIfNeeded(
                splashComponentReference,
                splashComponent
        );
        splashComponent.inject(splashActivity);
    }

    public void inject(OnboardingActivity activity) {
        //
    }

    public void inject(PaymentsFragment fragment) {
        PaymentsComponent paymentsComponent = appComponent.plus(new PaymentsModule());
        paymentsComponentReference = updateComponentIfNeeded(
                paymentsComponentReference,
                paymentsComponent
        );
        paymentsComponent.inject(fragment);
    }

}