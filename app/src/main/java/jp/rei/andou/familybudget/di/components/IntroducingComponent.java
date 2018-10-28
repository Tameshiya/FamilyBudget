package jp.rei.andou.familybudget.di.components;

import dagger.Subcomponent;
import jp.rei.andou.familybudget.di.modules.IntroducingModule;
import jp.rei.andou.familybudget.di.scopes.IntroducingScope;
import jp.rei.andou.familybudget.presentation.views.onboarding.IntroducingOnboarding;

@Subcomponent(modules = IntroducingModule.class)
@IntroducingScope
public interface IntroducingComponent {

    void inject(IntroducingOnboarding fragment);
}
