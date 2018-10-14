package jp.rei.andou.familybudget.di.components;

import dagger.BindsInstance;
import dagger.Subcomponent;
import jp.rei.andou.familybudget.di.modules.OnboardingModule;
import jp.rei.andou.familybudget.di.modules.PagerModule;
import jp.rei.andou.familybudget.di.scopes.OnboardingScope;
import jp.rei.andou.familybudget.presentation.views.onboarding.OnboardingActivity;

@Subcomponent(modules = {OnboardingModule.class, PagerModule.class})
@OnboardingScope
public interface OnboardingComponent {

    void inject(OnboardingActivity activity);

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        Builder bindActivity(OnboardingActivity activity);
        OnboardingComponent build();
    }
}
