package jp.rei.andou.familybudget.presentation.general;

import javax.inject.Inject;

import jp.rei.andou.familybudget.di.components.AppComponent;
import jp.rei.andou.familybudget.di.components.IntroducingComponent;
import jp.rei.andou.familybudget.di.components.OnboardingComponent;
import jp.rei.andou.familybudget.di.modules.IntroducingModule;
import jp.rei.andou.familybudget.presentation.views.onboarding.IntroducingOnboarding;
import jp.rei.andou.familybudget.presentation.views.onboarding.OnboardingActivity;

public class OnboardingComponentHandler {

    private final AppComponent appComponent;
    private OnboardingComponent onboardingComponent;
    private IntroducingComponent introducingComponent;

    @Inject
    public OnboardingComponentHandler(AppComponent appComponent) {
        this.appComponent = appComponent;
    }

    public void inject(OnboardingActivity activity) {
        onboardingComponent = appComponent.getOnboardingBuilder()
                                          .bindActivity(activity)
                                          .build();
        onboardingComponent.inject(activity);
    }

    public void inject(IntroducingOnboarding target) {
        if (onboardingComponent == null) { return; }
        introducingComponent = onboardingComponent.plus(new IntroducingModule());
        introducingComponent.inject(target);
    }

    public void destroyComponent(IntroducingOnboarding target) {
        introducingComponent = null;
    }

    public void destroyComponent(OnboardingActivity target) {
        onboardingComponent = null;
    }
}
