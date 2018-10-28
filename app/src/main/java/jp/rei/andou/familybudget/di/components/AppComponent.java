package jp.rei.andou.familybudget.di.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import jp.rei.andou.familybudget.di.modules.AppModule;
import jp.rei.andou.familybudget.di.modules.DatabaseModule;
import jp.rei.andou.familybudget.di.modules.PaymentsModule;
import jp.rei.andou.familybudget.di.modules.SplashModule;
import jp.rei.andou.familybudget.presentation.App;

@Component(modules = {AppModule.class, DatabaseModule.class})
@Singleton
public interface AppComponent {

    MainComponent.Builder getMainComponentBuilder();

    PaymentsComponent plus(PaymentsModule paymentsModule);

    SplashComponent plus(SplashModule splashModule);

    OnboardingComponent.Builder getOnboardingBuilder();

    void inject(App app);

//    OnboardingComponentHandler plus(IntroducingModule introducingModule);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder appContext(Context applicationContext);
        Builder databaseModule(DatabaseModule databaseModule);
        AppComponent build();
    }
}
