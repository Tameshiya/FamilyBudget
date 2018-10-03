package jp.rei.andou.familybudget.di.modules;

import dagger.Module;
import dagger.Provides;
import jp.rei.andou.familybudget.di.scopes.OnboardingScope;
import jp.rei.andou.familybudget.domain.onboarding.DatabaseOnboardingInteractor;
import jp.rei.andou.familybudget.domain.onboarding.OnboardingInteractor;
import jp.rei.andou.familybudget.presentation.presenters.OnboardingPresenter;
import jp.rei.andou.familybudget.presentation.router.FragmentNavigator;
import jp.rei.andou.familybudget.presentation.router.FragmentRouter;
import jp.rei.andou.familybudget.presentation.views.OnboardingActivity;
import jp.rei.andou.familybudget.presentation.views.OnboardingContract;

@Module
public class OnboardingModule {

    @Provides
    @OnboardingScope
    public FragmentNavigator provideFragmentNavigator(OnboardingActivity activity) {
        return new FragmentRouter(activity.getSupportFragmentManager());
    }

    @Provides
    @OnboardingScope
    public OnboardingInteractor provideInteractor() {
        return new DatabaseOnboardingInteractor();
    }

    @Provides
    @OnboardingScope
    public OnboardingContract.OnboardingPresenter providePresenter(OnboardingInteractor interactor) {
        return new OnboardingPresenter(interactor);
    }


}
