package jp.rei.andou.familybudget.domain.onboarding;

import io.reactivex.Single;

public interface OnboardingInteractor {

    Single<Long> register(String family, long chokin);

    boolean validateFamily(String family);

    boolean validateDeposit(long amount);

}
