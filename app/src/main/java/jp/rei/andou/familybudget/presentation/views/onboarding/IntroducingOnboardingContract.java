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
    }

    abstract class IntroducingPresenter extends Presenter<IntroducingView> {
        abstract void listenFamilyName(Observable<String> familyName);
        abstract void listenDeposit(Observable<String> deposit);
    }

}
