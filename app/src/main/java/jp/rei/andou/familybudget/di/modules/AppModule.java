package jp.rei.andou.familybudget.di.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jp.rei.andou.familybudget.presentation.App;
import jp.rei.andou.familybudget.presentation.general.ComponentsManager;
import jp.rei.andou.familybudget.presentation.router.ActivityNavigator;
import jp.rei.andou.familybudget.presentation.router.ActivityRouter;

@Module
public class AppModule {

    @Singleton
    @Provides
    public ActivityNavigator provideActivityNavigator(Context applicationContext) {
        return new ActivityRouter(((Application) applicationContext));
    }

    @Singleton
    @Provides
    public ComponentsManager provideComponentManager(Context applicationContext) {
        return new ComponentsManager(((App) applicationContext).getApplicationComponent());
    }

}
