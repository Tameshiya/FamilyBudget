package jp.rei.andou.familybudget.presentation.general;

import android.support.annotation.StringRes;

public interface BaseView {

    default void showToast(@StringRes int message, int duration) {
        //not implemented yet
    }

    default void showToast(String message, int duration) {
        //not implemented yet
    }

    default void showSnackbar(@StringRes int message, int duration) {
        //not implemented yet
    }

}
