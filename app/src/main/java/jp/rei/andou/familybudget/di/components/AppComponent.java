package jp.rei.andou.familybudget.di.components;

import javax.inject.Singleton;

import dagger.Component;
import jp.rei.andou.familybudget.di.modules.AppModule;
import jp.rei.andou.familybudget.di.modules.MainModule;
import jp.rei.andou.familybudget.di.modules.PaymentsModule;

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {

    MainComponent plus(MainModule mainModule);

    PaymentsComponent plus(PaymentsModule paymentsModule);
}
