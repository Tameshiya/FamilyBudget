package jp.rei.andou.familybudget.presentation.general;

import android.support.annotation.Nullable;

public abstract class Presenter<T extends BaseView> {

    @Nullable
    private T view;

    public T getViewOrThrow() {
        if (view == null) {
            throw new IllegalStateException("BaseView is null!");
        }
        return view;
    }

    public void bindView(T view) {
        this.view = view;
    }

    public void unbindView() {
        this.view = null;
    }

}
