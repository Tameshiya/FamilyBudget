package jp.rei.andou.familybudget.di.modules;

import dagger.Module;
import dagger.Provides;
import jp.rei.andou.familybudget.di.scopes.IntroducingScope;
import jp.rei.andou.familybudget.presentation.presenters.OnboardingPresenter;

@Module(includes = OnboardingModule.class)
public class IntroducingModule {

    @Provides
    @IntroducingScope
    public int provideSomeInt() {
        return 1;
    }

    @Provides
    @IntroducingScope
    public String provideFragmentNavigator(OnboardingPresenter manager) {
        return "";
    }

}
