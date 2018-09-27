package jp.rei.andou.familybudget.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jp.rei.andou.familybudget.presentation.App;
import jp.rei.andou.familybudget.presentation.router.ActivityNavigator;
import jp.rei.andou.familybudget.presentation.router.ActivityRouter;

@Module
public class AppModule {

    @Singleton
    @Provides
    public Context provideApplicationContext(Context applicationContext) {
        return applicationContext;
    }

    @Singleton
    @Provides
    public ActivityNavigator provideActivityNavigator(Context applicationContext) {
        return new ActivityRouter(((App) applicationContext));
    }

}
