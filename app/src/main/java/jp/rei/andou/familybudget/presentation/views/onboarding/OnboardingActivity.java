package jp.rei.andou.familybudget.presentation.views.onboarding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.rei.andou.familybudget.R;
import jp.rei.andou.familybudget.presentation.App;
import jp.rei.andou.familybudget.presentation.adapters.OnboardingPagerAdapter;
import jp.rei.andou.familybudget.presentation.presenters.OnboardingPresenter;

public class OnboardingActivity extends AppCompatActivity implements OnboardingContract.OnboardingView {

    @Inject
    OnboardingPresenter presenter;
    @BindView(R.id.container)
    ViewPager viewPager;
    @BindView(R.id.selector)
    TabLayout selector;
    @BindView(R.id.next)
    Button nextButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding__container);
        ButterKnife.bind(this);
        ((App) getApplication()).inject(this);
        presenter.bindView(this);
        selector.setupWithViewPager(viewPager, true);
    }

    @OnClick(R.id.next)
    @Override
    public void onNextPressed() {
        presenter.toNextStep();
    }

    @Override
    public void setupAdapter(OnboardingPagerAdapter adapter) {
        viewPager.setAdapter(adapter);
    }

    @Override
    public void enableNextButton(boolean enable) {
        nextButton.setEnabled(enable);
    }

    @Override
    public void swipeToNextWizard() {
        viewPager.arrowScroll(View.FOCUS_RIGHT);
    }

    @Override
    public int getCurrentPagePosition() {
        return viewPager.getCurrentItem();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((App) getApplicationContext()).destroyComponent(this);
    }
}
