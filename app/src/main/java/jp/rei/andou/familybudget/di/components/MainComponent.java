package jp.rei.andou.familybudget.di.components;

import dagger.Subcomponent;
import jp.rei.andou.familybudget.di.modules.MainModule;
import jp.rei.andou.familybudget.di.scopes.ContainerScope;
import jp.rei.andou.familybudget.presentation.views.MainActivity;

@Subcomponent(modules = MainModule.class)
@ContainerScope
public interface MainComponent {

    void inject(MainActivity activity);

}
