package jp.rei.andou.familybudget.presentation.general;

import javax.inject.Inject;
import javax.inject.Singleton;

import jp.rei.andou.familybudget.di.components.AppComponent;
import jp.rei.andou.familybudget.di.components.MainComponent;
import jp.rei.andou.familybudget.di.components.PaymentsComponent;
import jp.rei.andou.familybudget.di.modules.PaymentsModule;
import jp.rei.andou.familybudget.presentation.views.MainActivity;
import jp.rei.andou.familybudget.presentation.views.PaymentsFragment;

public class MainComponentHandler {

    private final AppComponent appComponent;
    @Singleton
    private MainComponent containerComponent;
    private PaymentsComponent paymentsComponent;

    @Inject
    public MainComponentHandler(AppComponent appComponent) {
        this.appComponent = appComponent;
    }


    public void inject(MainActivity mainActivity) {
        containerComponent = appComponent.getMainComponentBuilder()
                                         .bindActivity(mainActivity)
                                         .build();
        containerComponent.inject(mainActivity);
    }

    public void inject(PaymentsFragment fragment) {
        paymentsComponent = appComponent.plus(new PaymentsModule());
        paymentsComponent.inject(fragment);
    }

    public void destroyComponent(MainActivity target) {
        containerComponent = null;
        //todo think about subcomponents cleaning too
    }

}