package jp.rei.andou.familybudget.presentation;

import android.app.Application;

import jp.rei.andou.familybudget.di.components.AppComponent;
import jp.rei.andou.familybudget.di.components.DaggerAppComponent;
import jp.rei.andou.familybudget.di.modules.AppModule;
import jp.rei.andou.familybudget.presentation.general.ComponentsManager;
import lombok.experimental.Delegate;

public class App extends Application {

    private AppComponent mApplicationComponent;
    @Delegate
    private ComponentsManager mComponentsManager;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = buildComponent();
        mComponentsManager = new ComponentsManager(mApplicationComponent);
    }

    private AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
//                .databaseModule(new DatabaseModule(this))
//                .sessionModule(new SessionModule())
                .build();
    }
}
