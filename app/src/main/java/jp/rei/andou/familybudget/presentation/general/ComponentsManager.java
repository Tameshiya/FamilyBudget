package jp.rei.andou.familybudget.presentation.general;

import java.lang.ref.SoftReference;

import jp.rei.andou.familybudget.di.components.AppComponent;
import jp.rei.andou.familybudget.di.components.MainComponent;
import jp.rei.andou.familybudget.di.components.PaymentsComponent;
import jp.rei.andou.familybudget.di.modules.MainModule;
import jp.rei.andou.familybudget.di.modules.PaymentsModule;
import jp.rei.andou.familybudget.presentation.main.MainActivity;
import jp.rei.andou.familybudget.presentation.payments.PaymentsFragment;

public class ComponentsManager {

    private final AppComponent appComponent;
    private MainComponent containerComponent;
    /**
     * For avoiding "scope singletonfying" by keeping strong reference
     */
    private SoftReference<PaymentsComponent> paymentsComponent;

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
        containerComponent = appComponent.plus(new MainModule());
        containerComponent.inject(mainActivity);
    }

    public void inject(PaymentsFragment fragment) {
        paymentsComponent = updateComponentIfNeeded(
                paymentsComponent,
                appComponent.plus(new PaymentsModule())
        );
        PaymentsComponent component = paymentsComponent.get();
        if (component != null) {
            component.inject(fragment);
        }
    }

}