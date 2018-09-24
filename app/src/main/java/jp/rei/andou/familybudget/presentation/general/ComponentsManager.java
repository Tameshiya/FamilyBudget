package jp.rei.andou.familybudget.presentation.general;

import java.lang.ref.SoftReference;

import jp.rei.andou.familybudget.di.components.AppComponent;
import jp.rei.andou.familybudget.di.components.MainComponent;
import jp.rei.andou.familybudget.di.modules.MainModule;
import jp.rei.andou.familybudget.presentation.main.MainActivity;

public class ComponentsManager {

    private final AppComponent appComponent;
    private SoftReference<MainComponent> authorizationComponent;

    public ComponentsManager(AppComponent appComponent) {
        this.appComponent = appComponent;
    }

    private <T> SoftReference<T> updateComponentIfNeeded(SoftReference<T> reference, T value) {
        if (reference == null || reference.get() == null) {
            reference = new SoftReference<>(value);
        }
        return reference;
    }

    public void inject(MainActivity mainActivity) {
        authorizationComponent = updateComponentIfNeeded(
                authorizationComponent, appComponent.plus(new MainModule())
        );
        authorizationComponent.get().inject(mainActivity);
    }

}