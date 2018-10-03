package jp.rei.andou.familybudget.domain.onboarding;

public class DatabaseOnboardingInteractor implements OnboardingInteractor {

    @Override
    public void register(String family, long chokin) {

    }

    @Override
    public boolean validateFamily(String family) {
        return false;
    }

    @Override
    public boolean validateChokin(long amount) {
        return false;
    }
}
