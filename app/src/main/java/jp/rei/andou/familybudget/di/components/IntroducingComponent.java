package jp.rei.andou.familybudget.di.components;

import dagger.BindsInstance;
import dagger.Subcomponent;
import jp.rei.andou.familybudget.di.modules.IntroducingModule;
import jp.rei.andou.familybudget.di.modules.PagerModule;
import jp.rei.andou.familybudget.di.scopes.OnboardingScope;
import jp.rei.andou.familybudget.presentation.views.onboarding.OnboardingActivity;

@Subcomponent(modules = {IntroducingModule.class, PagerModule.class})
@OnboardingScope
public interface IntroducingComponent {

    void inject(OnboardingActivity activity);

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        Builder bindActivity(OnboardingActivity activity);
        IntroducingComponent build();
    }
}
