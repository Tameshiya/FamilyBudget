package jp.rei.andou.familybudget.presentation.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import jp.rei.andou.familybudget.presentation.App;


public class SplashActivity extends AppCompatActivity implements SplashContract.SplashView {

    @Inject
    SplashPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getApplicationContext()).inject(this);
        presenter.bindView(this);
    }

    @Override
    public void showToast(int message, int duration) {

    }

    @Override
    public void showToast(String message, int duration) {

    }

    @Override
    public void showSnackbar(int message, int duration) {

    }

    @Override
    public void setSettingsPrepareMode() {

    }

    @Override
    public void onNextPressed() {

    }
}
