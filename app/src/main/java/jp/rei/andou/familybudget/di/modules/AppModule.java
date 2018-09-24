package jp.rei.andou.familybudget.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Context context;

    public AppModule(Context applicationContext) {
        this.context = applicationContext;
    }

    @Singleton
    @Provides
    public Context provideApplicationContext() {
        return context;
    }
}
