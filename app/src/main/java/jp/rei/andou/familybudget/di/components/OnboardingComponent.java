package jp.rei.andou.familybudget.di.components;

import dagger.Subcomponent;
import jp.rei.andou.familybudget.di.modules.OnboardingModule;
import jp.rei.andou.familybudget.di.scopes.OnboardingScope;
import jp.rei.andou.familybudget.presentation.views.OnboardingActivity;

@Subcomponent(modules = OnboardingModule.class)
@OnboardingScope
public interface OnboardingComponent {

    void inject(OnboardingActivity activity);

}
