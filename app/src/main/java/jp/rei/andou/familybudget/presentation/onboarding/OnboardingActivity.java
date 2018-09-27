package jp.rei.andou.familybudget.presentation.onboarding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import jp.rei.andou.familybudget.presentation.App;

public class OnboardingActivity extends AppCompatActivity implements OnboardingContract.OnboardingView{

    @Inject
    OnboardingPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getApplication()).inject(this);
        ButterKnife.bind(this);

    }

//    @OnClick(R.)
    @Override
    public void onNextPressed() {

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
}
