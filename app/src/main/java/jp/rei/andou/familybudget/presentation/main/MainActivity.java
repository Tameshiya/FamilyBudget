package jp.rei.andou.familybudget.presentation.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import jp.rei.andou.familybudget.R;

public class MainActivity extends AppCompatActivity implements ContainerContract.MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
