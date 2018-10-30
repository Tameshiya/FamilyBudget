package jp.rei.andou.familybudget.presentation.views.onboarding;

import io.reactivex.Observable;
import jp.rei.andou.familybudget.presentation.general.BaseView;
import jp.rei.andou.familybudget.presentation.presenters.Presenter;

public interface IntroducingOnboardingContract {

    interface IntroducingView extends BaseView {
        void showInputVerifiedStamp();
        void showInvalidInputStamp();
        void showFamilyNameInputError(String error);
        void hideFamilyNameInputError();
        void showFamilyDepositInputError(String error);
        void hideFamilyDepositInputError();
        void hideAnyStamp();
        String getInputtedFamilyName();
        long getInputtedFamilyDeposit();
    }

    abstract class IntroducingPresenter extends Presenter<IntroducingView> {
        public abstract void listenFamilyName(Observable<CharSequence> familyNameListener);
        public abstract void listenDeposit(Observable<CharSequence> deposit);
        public abstract void login(String familyName, long deposit);
    }

}
