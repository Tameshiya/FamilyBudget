package jp.rei.andou.familybudget.di.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import jp.rei.andou.familybudget.di.modules.AppModule;
import jp.rei.andou.familybudget.di.modules.MainModule;
import jp.rei.andou.familybudget.di.modules.OnboardingModule;
import jp.rei.andou.familybudget.di.modules.PaymentsModule;
import jp.rei.andou.familybudget.di.modules.SplashModule;

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {

    MainComponent plus(MainModule mainModule);

    PaymentsComponent plus(PaymentsModule paymentsModule);

    SplashComponent plus(SplashModule splashModule);

    OnboardingComponent plus(OnboardingModule onboadingModule);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder appModule(Context applicationContext);
        AppComponent build();
    }
}
