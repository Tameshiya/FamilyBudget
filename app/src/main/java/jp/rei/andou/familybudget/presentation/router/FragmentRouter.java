package jp.rei.andou.familybudget.presentation.router;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.lang.ref.WeakReference;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

import jp.rei.andou.familybudget.R;

public class FragmentRouter implements FragmentNavigator {

    private final FragmentManager fragmentManager;
    private final Deque<WeakReference<Fragment>> fragments = new ConcurrentLinkedDeque<>();

    public FragmentRouter(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Override
    public void back() {
        fragmentManager.popBackStack();
    }

    @Override
    public void rollbackTo(Fragment fragment) {
        WeakReference<Fragment> currentFragmentReference = fragments.pollLast();
        while (fragments.peekLast().get().equals(fragment)) {
            Fragment lastFragment = fragments.pollLast().get();
            if (lastFragment != null) {
                fragmentManager.beginTransaction()
                               .remove(lastFragment)
                               .commitAllowingStateLoss();
            }
        }
        fragments.add(currentFragmentReference);
        fragmentManager.popBackStack();
    }

    @Override
    public void newScreen(Fragment fragment) {
        fragments.add(new WeakReference<>(fragment));
        fragmentManager.beginTransaction()
                       .add(R.id.container, fragment)
                       .commit();
    }

    @Override
    public void replaceWith(Fragment fragment) {
        fragmentManager.beginTransaction()
                       .replace(R.id.container, fragment)
                       .commitAllowingStateLoss();
    }


    @Override
    public void rollbackToRoot() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment stackRootFragment = fragments.pollFirst().get();
        for (WeakReference<Fragment> fragmentReference : fragments) {
            Fragment fragment = fragmentReference.get();
            if (fragment != null) {
                transaction.remove(fragment);
            }
        }
        if (stackRootFragment != null) {
            transaction.add(R.id.container, stackRootFragment)
                       .commitAllowingStateLoss();
            fragments.add(new WeakReference<>(stackRootFragment));
        }
    }
}
