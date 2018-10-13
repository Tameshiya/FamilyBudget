package jp.rei.andou.familybudget.presentation.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.rei.andou.familybudget.R;
import jp.rei.andou.familybudget.presentation.App;
import jp.rei.andou.familybudget.presentation.presenters.OnboardingPresenter;

import static jp.rei.andou.familybudget.presentation.views.OnboardingContract.OnboardingView;

public class OnboardingActivity extends AppCompatActivity implements OnboardingView {

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
        //REMOVE BELLOW's SHIT!!!!!!!!!!!
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                return position == 0 ? new WelcomeOnboarding() : new Fragment();
            }

            @Override
            public int getCount() {
                return 2;
            }
        });
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
