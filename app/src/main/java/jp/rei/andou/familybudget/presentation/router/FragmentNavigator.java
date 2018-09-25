package jp.rei.andou.familybudget.presentation.router;

import android.support.v4.app.Fragment;

public interface FragmentNavigator {

    void back();

    void rollbackTo(Fragment fragment);

    void newScreen(Fragment fragment);

    void replaceWith(Fragment fragment);

    void rollbackToRoot();
}
