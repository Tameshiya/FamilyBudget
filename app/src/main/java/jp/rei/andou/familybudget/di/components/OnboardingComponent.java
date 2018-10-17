package jp.rei.andou.familybudget.di.components;

import dagger.Subcomponent;
import jp.rei.andou.familybudget.di.modules.OnboardingModule;
import jp.rei.andou.familybudget.presentation.views.onboarding.IntroducingOnboarding;

@Subcomponent(modules = OnboardingModule.class)
public interface OnboardingComponent extends IntroducingComponent {

    void inject(IntroducingOnboarding onboarding);

}
