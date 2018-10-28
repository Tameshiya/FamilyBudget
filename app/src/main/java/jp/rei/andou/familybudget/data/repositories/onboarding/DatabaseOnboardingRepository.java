package jp.rei.andou.familybudget.data.repositories.onboarding;


import javax.inject.Inject;

import jp.rei.andou.familybudget.data.database.dao.AccountDao;
import jp.rei.andou.familybudget.data.database.entites.FamilyAccount;
import jp.rei.andou.familybudget.data.database.entites.Salary;

public class DatabaseOnboardingRepository implements OnboardingRepository {

    private final AccountDao accountDao;

    @Inject
    public DatabaseOnboardingRepository(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public long addNewFamilyAccount(FamilyAccount account) {
        return accountDao.insertAccount(account);
    }

    @Override
    public long addAccountSalary(Salary salary) {
        return accountDao.insertSalary(salary);
    }
}
