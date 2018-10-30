package jp.rei.andou.familybudget.presentation.presenters;

import com.jakewharton.rxrelay2.PublishRelay;

import javax.inject.Inject;

import jp.rei.andou.familybudget.presentation.adapters.OnboardingPagerAdapter;
import jp.rei.andou.familybudget.presentation.model.OnboardingEvent;

import static jp.rei.andou.familybudget.presentation.views.onboarding.OnboardingContract.OnboardingView;

//todo Refactor to "SmartRouter" implementation instead of this SUPER-presenter implementation 
public class OnboardingPresenterImpl extends OnboardingPresenter {

    private final OnboardingPagerAdapter pagerAdapter;
    private final PublishRelay<OnboardingEvent> onboardingEvents;

    @Inject
    public OnboardingPresenterImpl(PublishRelay<OnboardingEvent> onboardingEvents,
                                   OnboardingPagerAdapter pagerAdapter) {
        this.pagerAdapter = pagerAdapter;
        this.onboardingEvents = onboardingEvents;
        onboardingEvents.filter(event -> event.equals(OnboardingEvent.ENABLE_NEXT_BUTTON))
                        .subscribe((event) -> getViewOrThrow().enableNextButton(true));
        onboardingEvents.filter(event -> event.equals(OnboardingEvent.DISABLE_NEXT_BUTTON))
                        .subscribe(event -> getViewOrThrow().enableNextButton(false));
    }

    @Override
    void onViewBound(OnboardingView view) {
        view.setupAdapter(pagerAdapter);
    }

    @Override
    public void toNextStep() {
        onboardingEvents.accept(OnboardingEvent.NEXT);
    }
}
