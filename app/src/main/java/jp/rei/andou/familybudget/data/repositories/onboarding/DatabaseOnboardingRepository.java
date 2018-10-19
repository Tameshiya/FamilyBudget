package jp.rei.andou.familybudget.data.repositories.onboarding;


import javax.inject.Inject;

import io.reactivex.Single;
import jp.rei.andou.familybudget.data.database.dao.AccountDao;
import jp.rei.andou.familybudget.data.database.entites.FamilyAccount;
import jp.rei.andou.familybudget.data.database.entites.Salary;

public class DatabaseOnboardingRepository implements OnboardingRepository {

    AccountDao accountDao;

    @Inject
    public DatabaseOnboardingRepository(AccountDao accountDao) {
    }

    @Override
    public Single<Long> addNewFamilyAccount(FamilyAccount account) {
        return null;
    }

    @Override
    public Single<Long> addAccountSalary(Salary salary) {
        return null;
    }
}
