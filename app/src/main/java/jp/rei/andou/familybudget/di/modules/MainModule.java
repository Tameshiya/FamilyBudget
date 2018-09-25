package jp.rei.andou.familybudget.di.modules;

import dagger.Module;
import dagger.Provides;
import jp.rei.andou.familybudget.di.scopes.ContainerScope;
import jp.rei.andou.familybudget.presentation.main.MainActivity;
import jp.rei.andou.familybudget.presentation.router.FragmentNavigator;
import jp.rei.andou.familybudget.presentation.router.FragmentRouter;

@Module
public class MainModule {

    @ContainerScope
    @Provides
    public FragmentNavigator provideNavigator(MainActivity activity) {
        return new FragmentRouter(activity.getSupportFragmentManager());
    }

}
