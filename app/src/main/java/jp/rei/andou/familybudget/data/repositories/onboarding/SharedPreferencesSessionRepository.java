package jp.rei.andou.familybudget.data.repositories.onboarding;


import android.content.SharedPreferences;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

public class SharedPreferencesSessionRepository implements SessionRepository {

    private final SharedPreferences sharedPreferences;
    private static final String FAMILY_ACCOUNT_ID = "familyAccountIdTAG";

    @Inject
    public SharedPreferencesSessionRepository(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public Completable saveCurrentFamily(long familyAccountId) {
        return Completable.fromAction(
                () -> sharedPreferences.edit()
                                       .putLong(FAMILY_ACCOUNT_ID, familyAccountId)
        );
    }

    @Override
    public Single<Long> getCurrentFamilyAccountId() {
        return Single.just(
                sharedPreferences.getLong(FAMILY_ACCOUNT_ID, -1)
        );
    }
}
