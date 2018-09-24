package jp.rei.andou.familybudget.di.modules;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    public int provideSomeInt() {
        return 1;
    }

}
