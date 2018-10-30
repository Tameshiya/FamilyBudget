package jp.rei.andou.familybudget.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jp.rei.andou.familybudget.data.repositories.onboarding.SessionRepository;
import jp.rei.andou.familybudget.data.repositories.onboarding.SharedPreferencesSessionRepository;
import jp.rei.andou.familybudget.presentation.App;
import jp.rei.andou.familybudget.presentation.general.MainComponentHandler;
import jp.rei.andou.familybudget.presentation.router.ActivityNavigator;
import jp.rei.andou.familybudget.presentation.router.ActivityRouter;

@Module
public class AppModule {

    private static String GENERAL_SHARED_PREFERENCES = "GENERAL_SHARED_PREFERENCES_TAG";

    @Singleton
    @Provides
    public ActivityNavigator provideActivityNavigator(Context applicationContext) {
        return new ActivityRouter(((Application) applicationContext));
    }

    @Singleton
    @Provides
    public MainComponentHandler provideComponentManager(Context applicationContext) {
        return new MainComponentHandler(((App) applicationContext).getApplicationComponent());
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharedPreferences(Context applicationContext) {
        return applicationContext.getSharedPreferences(GENERAL_SHARED_PREFERENCES, Context.MODE_PRIVATE);
    }

    @Provides
    public SessionRepository provideSessionRepository(SharedPreferencesSessionRepository repository) {
        return repository;
    }

}
