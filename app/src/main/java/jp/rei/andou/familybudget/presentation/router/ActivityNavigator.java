package jp.rei.andou.familybudget.presentation.router;


import android.app.Activity;

public interface ActivityNavigator {

    void back();

    void rollbackTo(Class<? extends Activity> screen);

    void newScreen(Class<? extends Activity> screen);

    void replaceWith(Class<? extends Activity> screen);

    void rollbackToRoot();

}
