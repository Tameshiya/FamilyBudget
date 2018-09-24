package jp.rei.andou.familybudget.presentation.general;

import android.support.annotation.StringRes;

public interface BaseView {

    void showToast(@StringRes int message, int duration);

    void showToast(String message, int duration);

    void showSnackbar(@StringRes int message, int duration);

}
