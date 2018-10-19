package jp.rei.andou.familybudget.di.modules;

import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import jp.rei.andou.familybudget.data.repositories.onboarding.DatabaseOnboardingRepository;
import jp.rei.andou.familybudget.di.scopes.OnboardingScope;
import jp.rei.andou.familybudget.domain.onboarding.DatabaseOnboardingInteractor;
import jp.rei.andou.familybudget.domain.onboarding.OnboardingInteractor;
import jp.rei.andou.familybudget.presentation.presenters.OnboardingPresenter;
import jp.rei.andou.familybudget.presentation.presenters.OnboardingPresenterImpl;
import jp.rei.andou.familybudget.presentation.router.FragmentNavigator;
import jp.rei.andou.familybudget.presentation.router.FragmentRouter;
import jp.rei.andou.familybudget.presentation.views.onboarding.OnboardingActivity;

@Module
public class OnboardingModule {

    @Provides
    @OnboardingScope
    public FragmentNavigator provideFragmentNavigator(FragmentManager fragmentManager) {
        return new FragmentRouter(fragmentManager);
    }

    @Provides
    @OnboardingScope
    public FragmentManager provideFragmentManager(OnboardingActivity activity) {
        return activity.getSupportFragmentManager();
    }

    @Provides
    @OnboardingScope
    public OnboardingInteractor provideInteractor() {
        //todo provide AccountDao instead null
        return new DatabaseOnboardingInteractor(new DatabaseOnboardingRepository(null));
    }

    @Provides
    @OnboardingScope
    public OnboardingPresenter providePresenter(OnboardingPresenterImpl presenter) {
        return presenter;
    }


}
