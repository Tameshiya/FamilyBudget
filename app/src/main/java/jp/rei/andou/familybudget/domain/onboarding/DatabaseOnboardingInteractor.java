package jp.rei.andou.familybudget.domain.onboarding;

import java.util.regex.Pattern;

import javax.inject.Inject;

import io.reactivex.Single;
import jp.rei.andou.familybudget.data.database.entites.FamilyAccount;
import jp.rei.andou.familybudget.data.database.entites.Salary;
import jp.rei.andou.familybudget.data.repositories.onboarding.OnboardingRepository;

public class DatabaseOnboardingInteractor implements OnboardingInteractor {

    private final OnboardingRepository onboardingRepository;

    @Inject
    public DatabaseOnboardingInteractor(OnboardingRepository repository) {
        this.onboardingRepository = repository;
    }

    @Override
    public Single<Long> register(String family, long deposit) {
        //todo ToSalaryConverter & add currencyCode to layout
        Salary salary = new Salary();
        salary.setUnits(deposit);
        salary.setSubunits(deposit);
        return Single.fromCallable(() -> onboardingRepository.addAccountSalary(salary))
                     .map(salaryId -> {
                         FamilyAccount familyAccount = new FamilyAccount();
                         familyAccount.setName(family);
                         familyAccount.setSalaryId(salaryId);
                         return familyAccount;
                     }).flatMap(
                        familyAccount -> Single.fromCallable(
                                () -> onboardingRepository.addNewFamilyAccount(familyAccount)
                        )
                    );
    }

    @Override
    public boolean validateFamily(CharSequence family) {
        return Pattern.compile("[a-z]{5,}")
                      .matcher(family)
                      .find();
    }

    @Override
    public boolean validateDeposit(CharSequence amount) {
        return Pattern.compile("[1-9][0-9]*")
                      .matcher(amount)
                      .find();
    }
}
