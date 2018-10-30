package jp.rei.andou.familybudget.data.repositories.onboarding;


import io.reactivex.Completable;
import io.reactivex.Single;

public interface SessionRepository {

    Completable saveCurrentFamily(long familyAccountId);
    Single<Long> getCurrentFamilyAccountId();

}
