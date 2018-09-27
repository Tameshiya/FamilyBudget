package jp.rei.andou.familybudget.domain.onboarding;

public interface OnboardingInteractor {

    void register(String family, long chokin);

    boolean validateFamily(String family);

    boolean validateChokin(long amount);

}
