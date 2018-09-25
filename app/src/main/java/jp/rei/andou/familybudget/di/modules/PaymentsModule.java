package jp.rei.andou.familybudget.di.modules;

import dagger.Module;
import dagger.Provides;
import jp.rei.andou.familybudget.di.scopes.PaymentsScope;
import jp.rei.andou.familybudget.presentation.payments.PaymentsPresenter;

@Module
public class PaymentsModule {

    @Provides
    @PaymentsScope
    public PaymentsPresenter providePaymentsPresenter() {
        return new PaymentsPresenter();
    }

}
