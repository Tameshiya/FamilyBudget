package jp.rei.andou.familybudget.di.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import jp.rei.andou.familybudget.di.modules.AppModule;
import jp.rei.andou.familybudget.di.modules.IntroducingModule;
import jp.rei.andou.familybudget.di.modules.MainModule;
import jp.rei.andou.familybudget.di.modules.PaymentsModule;
import jp.rei.andou.familybudget.di.modules.SplashModule;
import jp.rei.andou.familybudget.presentation.App;

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {

    MainComponent plus(MainModule mainModule);

    PaymentsComponent plus(PaymentsModule paymentsModule);

    SplashComponent plus(SplashModule splashModule);

    OnboardingComponent.Builder getOnboardingBuilder();

    void inject(App app);

    IntroducingComponent plus(IntroducingModule introducingModule);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder appContext(Context applicationContext);
        AppComponent build();
    }
}
