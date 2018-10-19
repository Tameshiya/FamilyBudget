package jp.rei.andou.familybudget.data.repositories.onboarding;


import io.reactivex.Single;
import jp.rei.andou.familybudget.data.database.entites.FamilyAccount;
import jp.rei.andou.familybudget.data.database.entites.Salary;

public interface OnboardingRepository {

    Single<Long> addNewFamilyAccount(FamilyAccount account);

    Single<Long> addAccountSalary(Salary salary);

}
