package jp.rei.andou.familybudget.di.modules;

import dagger.Module;
import dagger.Provides;
import jp.rei.andou.familybudget.di.scopes.PaymentsScope;
import jp.rei.andou.familybudget.presentation.presenters.PaymentsPresenter;
import jp.rei.andou.familybudget.presentation.views.PaymentsContract;

@Module
public class PaymentsModule {

    @Provides
    @PaymentsScope
    public PaymentsContract.PaymentsPresenter providePaymentsPresenter() {
        return new PaymentsPresenter();
    }

}
