package jp.rei.andou.familybudget.presentation.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import jp.rei.andou.familybudget.R;
import jp.rei.andou.familybudget.presentation.App;

import static jp.rei.andou.familybudget.presentation.views.ContainerContract.MainPresenter;
import static jp.rei.andou.familybudget.presentation.views.ContainerContract.MainView;

public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplicationContext()).inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((App) getApplicationContext()).destroyComponent(this);
    }
}
