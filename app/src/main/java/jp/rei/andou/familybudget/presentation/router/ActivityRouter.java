package jp.rei.andou.familybudget.presentation.router;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

import javax.inject.Inject;

import jp.rei.andou.familybudget.presentation.App;

public class ActivityRouter implements ActivityNavigator, Application.ActivityLifecycleCallbacks {

    private final Deque<WeakReference<? extends Activity>> screens = new ConcurrentLinkedDeque<>();
    private final App applicationContext;

    @Inject
    public ActivityRouter(App applicationContext) {
        this.applicationContext = applicationContext;
        applicationContext.registerActivityLifecycleCallbacks(this);
    }

    public <S extends Activity> void registerScreen(S screen) {
        if (!isScreenRegistered(screen)) {
            this.screens.add(new WeakReference<>(screen));
        }
    }

    private <S extends Activity> boolean isScreenRegistered(S screen) {
        for (WeakReference reference : screens) {
            if (reference.get() == null) {
                screens.remove(reference);
            } else if (reference.get() == screen) {
                return true;
            }
        }
        return false;
    }

    private void updateScreens() {
        for (WeakReference reference : screens) {
            if (reference.get() == null) {
                screens.remove(reference);
            }
        }
    }

    @Override
    public void newScreen(Class<? extends Activity> screen) {
        Intent intent = new Intent(applicationContext, screen);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        applicationContext.startActivity(intent);
    }

    @Override
    public void replaceWith(Class<? extends Activity> screen) {
        back();
        newScreen(screen);
    }

    @Override
    public void back() {
        updateScreens();
        getCurrentActivity().finish();
        //todo think about force bringing next on stack activity to front
        // TODO: 26.08.2018 add intents
    }

    @NonNull
    private Activity getCurrentActivity() {
        if (screens.isEmpty()) {
            throw new IllegalStateException("At this moment activity stack is empty");
        }
        return screens.pollLast()
                      .get();
    }

    @Override
    public void rollbackTo(Class<? extends Activity> screen) {

    }


    @Override
    public void rollbackToRoot() {
//        screens.forEach(); finish activities in foreach, excepting root screen
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        registerScreen(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        destroyScreen(activity);
    }

    private void destroyScreen(Activity activity) {
        for (WeakReference reference : screens) {
            if (reference.get() == null || reference.get() == activity) {
                screens.remove(reference);
            }
        }
    }
}
