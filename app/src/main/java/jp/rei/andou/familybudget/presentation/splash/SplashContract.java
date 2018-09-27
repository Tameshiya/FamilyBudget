package jp.rei.andou.familybudget.presentation.splash;

import jp.rei.andou.familybudget.presentation.general.BaseView;
import jp.rei.andou.familybudget.presentation.general.Presenter;

public interface SplashContract {

    interface SplashView extends BaseView {
        void setSettingsPrepareMode();
        void onNextPressed();
    }

    abstract class SplashPresenterContract extends Presenter<SplashView> {
        abstract void onReadyToStart();
    }

}
