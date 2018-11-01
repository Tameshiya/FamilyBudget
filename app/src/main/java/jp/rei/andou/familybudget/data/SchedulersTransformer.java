package jp.rei.andou.familybudget.data;


import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.CompletableTransformer;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.MaybeTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Stupid implementation <<all in one>>
 * todo refactor copy-pasting to Factory-like approach
 * @param <T>
 */
public class SchedulersTransformer<T> implements SingleTransformer<T, T>,
        ObservableTransformer<T, T>, MaybeTransformer<T, T>, CompletableTransformer {

    private SchedulersTransformer() {}

    public static <T1> SchedulersTransformer<T1> create() {
        return new SchedulersTransformer<>();
    }

    @Override
    public SingleSource<T> apply(Single<T> upstream) {
        return upstream.observeOn(AndroidSchedulers.mainThread())
                       .subscribeOn(Schedulers.io());
    }

    @Override
    public CompletableSource apply(Completable upstream) {
        return upstream.observeOn(AndroidSchedulers.mainThread())
                       .subscribeOn(Schedulers.io());
    }

    @Override
    public MaybeSource<T> apply(Maybe<T> upstream) {
        return upstream.observeOn(AndroidSchedulers.mainThread())
                       .subscribeOn(Schedulers.io());
    }

    @Override
    public ObservableSource<T> apply(Observable<T> upstream) {
        return upstream.observeOn(AndroidSchedulers.mainThread())
                       .subscribeOn(Schedulers.io());
    }
}
