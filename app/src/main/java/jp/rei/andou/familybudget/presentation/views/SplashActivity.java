package jp.rei.andou.familybudget.presentation.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import jp.rei.andou.familybudget.presentation.App;

import static jp.rei.andou.familybudget.presentation.views.SplashContract.SplashView;

public class SplashActivity extends AppCompatActivity implements SplashView {

    @Inject
    SplashContract.SplashPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getApplicationContext()).inject(this);
        presenter.bindView(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        presenter.onReadyToStart();
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
