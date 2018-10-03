package jp.rei.andou.familybudget.presentation.views;

import jp.rei.andou.familybudget.presentation.general.BaseView;
import jp.rei.andou.familybudget.presentation.presenters.Presenter;

public interface SplashContract {

    interface SplashView extends BaseView {
        void setSettingsPrepareMode();
        void onNextPressed();
    }

    abstract class SplashPresenter extends Presenter<SplashView> {
        public abstract void onReadyToStart();
    }

}
