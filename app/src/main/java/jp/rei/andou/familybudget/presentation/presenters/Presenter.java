package jp.rei.andou.familybudget.presentation.presenters;

import android.support.annotation.Nullable;

import jp.rei.andou.familybudget.presentation.general.BaseView;

public abstract class Presenter<T extends BaseView> {

    @Nullable
    private T view;

    public T getViewOrThrow() {
        if (view == null) {
            throw new IllegalStateException("BaseView is null! Did you forget to call Presenter#bindView?");
        }
        return view;
    }

    public void bindView(T view) {
        this.view = view;
        onViewBound(view);
    }

    /*package-private*/ void onViewBound(T view) {}

    public void unbindView() {
        this.view = null;
    }

}
