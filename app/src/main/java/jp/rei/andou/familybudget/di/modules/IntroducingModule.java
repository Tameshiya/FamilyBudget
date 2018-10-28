package jp.rei.andou.familybudget.di.modules;

import dagger.Module;
import dagger.Provides;
import jp.rei.andou.familybudget.di.scopes.IntroducingScope;
import jp.rei.andou.familybudget.presentation.presenters.IntroducingPresenterImpl;
import jp.rei.andou.familybudget.presentation.views.onboarding.IntroducingOnboardingContract.IntroducingPresenter;

@Module(/*includes = OnboardingModule.class*/)
public class IntroducingModule {

    @Provides
    @IntroducingScope
    public IntroducingPresenter provideIntroducingPresenter(IntroducingPresenterImpl presenter) {
        return presenter;
    }

}
