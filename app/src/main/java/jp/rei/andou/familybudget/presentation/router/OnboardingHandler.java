package jp.rei.andou.familybudget.presentation.router;

import android.app.Activity;

public interface OnboardingHandler {
    void goToNextScreen();
    void goToPreviousScreen();
    void finishOnboardingWith(Class<? extends Activity> activity);
}
