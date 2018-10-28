package jp.rei.andou.familybudget.data.repositories.onboarding;


import jp.rei.andou.familybudget.data.database.entites.FamilyAccount;
import jp.rei.andou.familybudget.data.database.entites.Salary;

public interface OnboardingRepository {

    long addNewFamilyAccount(FamilyAccount account);

    long addAccountSalary(Salary salary);

}
