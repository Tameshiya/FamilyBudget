package jp.rei.andou.familybudget.domain.onboarding;

import io.reactivex.Single;

public interface OnboardingInteractor {

    Single<Long> register(String family, long deposit);

    boolean validateFamily(CharSequence family);

    boolean validateDeposit(CharSequence amount);

}
