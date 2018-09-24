package jp.rei.andou.familybudget.di.components;

import javax.inject.Singleton;

import dagger.Component;
import jp.rei.andou.familybudget.di.modules.AppModule;
import jp.rei.andou.familybudget.di.modules.MainModule;

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {

    MainComponent plus(MainModule mainModule);

}
