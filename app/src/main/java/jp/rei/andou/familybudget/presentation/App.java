package jp.rei.andou.familybudget.presentation;

import android.app.Application;

import javax.inject.Inject;

import jp.rei.andou.familybudget.di.components.AppComponent;
import jp.rei.andou.familybudget.di.components.DaggerAppComponent;
import jp.rei.andou.familybudget.di.modules.DatabaseModule;
import jp.rei.andou.familybudget.presentation.general.MainComponentHandler;
import jp.rei.andou.familybudget.presentation.general.OnboardingComponentHandler;
import jp.rei.andou.familybudget.presentation.general.SplashComponentHandler;
import jp.rei.andou.familybudget.presentation.router.ActivityNavigator;
import lombok.Getter;
import lombok.experimental.Delegate;

public class App extends Application {

    @Getter
    private AppComponent applicationComponent;
    @Inject
    @Delegate
    MainComponentHandler mComponentsManager;
    @Inject
    @Delegate
    ActivityNavigator activityNavigator;
    @Inject
    @Delegate
    SplashComponentHandler splashComponentHandler;
    @Inject
    @Delegate
    OnboardingComponentHandler onboardingComponentHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = buildComponent();
        applicationComponent.inject(this);
    }

    private AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .appContext(this)
                .databaseModule(new DatabaseModule(this))
//                .sessionModule(new SessionModule())
                .build();
    }
}
