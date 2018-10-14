package jp.rei.andou.familybudget.di.modules;

import android.support.v4.app.Fragment;

import java.util.Arrays;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import jp.rei.andou.familybudget.di.scopes.OnboardingScope;
import jp.rei.andou.familybudget.presentation.presenters.onboarding.OnboardingPagerAdapterPresenterImpl;
import jp.rei.andou.familybudget.presentation.views.onboarding.IntroducingOnboarding;
import jp.rei.andou.familybudget.presentation.views.onboarding.WelcomeOnboarding;

import static jp.rei.andou.familybudget.presentation.views.onboarding.OnboardingContract.OnboardingPagerAdapterPresenter;

@Module
public class PagerModule {

    @OnboardingScope
    @Provides
    public OnboardingPagerAdapterPresenter providePagerPresenter(List<Fragment> fragments) {
        return new OnboardingPagerAdapterPresenterImpl(fragments);
    }

    /**
     * Provider for providing {@link List} of {@link Fragment}, it's DI\XML responsibility, cuz Fragments it's framework relation
     * @return List of Fragment for onboarding processing
     */
    @OnboardingScope
    @Provides
    public List<Fragment> provideOnboardingFragmentList() {
        return Arrays.asList(
                new WelcomeOnboarding(),
                new IntroducingOnboarding()
        );
    }

}
