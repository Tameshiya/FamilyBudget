package jp.rei.andou.familybudget.presentation.onboarding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.rei.andou.familybudget.R;
import jp.rei.andou.familybudget.presentation.App;

public class OnboardingActivity extends AppCompatActivity implements OnboardingContract.OnboardingView{

    @Inject
    OnboardingPresenter presenter;
    @BindView(R.id.container)
    ViewPager viewPager;
    @BindView(R.id.selector)
    TabLayout selector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding__container);
        ((App) getApplication()).inject(this);
        ButterKnife.bind(this);
        selector.setupWithViewPager(viewPager, true);
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
