package jp.rei.andou.familybudget.di.components;

import dagger.Subcomponent;
import jp.rei.andou.familybudget.di.modules.PaymentsModule;
import jp.rei.andou.familybudget.di.scopes.PaymentsScope;
import jp.rei.andou.familybudget.presentation.payments.PaymentsFragment;

@Subcomponent(modules = PaymentsModule.class)
@PaymentsScope
public interface PaymentsComponent extends MainComponent {

    void inject(PaymentsFragment fragment);

}
