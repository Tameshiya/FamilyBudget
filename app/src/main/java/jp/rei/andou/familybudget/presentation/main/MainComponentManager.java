package jp.rei.andou.familybudget.presentation.main;

import javax.inject.Inject;
import javax.inject.Singleton;

import jp.rei.andou.familybudget.di.components.AppComponent;
import jp.rei.andou.familybudget.di.components.MainComponent;
import jp.rei.andou.familybudget.di.modules.MainModule;

public class MainComponentManager {

    private final AppComponent appComponent;
    @Singleton
    private MainComponent containerComponent;

    @Inject
    public MainComponentManager(AppComponent appComponent) {
        this.appComponent = appComponent;
    }

    public void inject(MainActivity mainActivity) {
        if (containerComponent == null) {
            containerComponent = appComponent.plus(new MainModule());
            containerComponent.inject(mainActivity);
        }
    }

}
