package jp.rei.andou.familybudget.presentation.general;

/**
 * Try to validate generic type of this interface for both two classes: Activity and Fragment
 * T extends Activity or T extends Fragment
 * @param <T>
 */
public interface ComponentInjector<T> {

    void inject(T instance);

}
