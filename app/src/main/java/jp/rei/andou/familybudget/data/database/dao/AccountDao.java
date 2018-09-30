package jp.rei.andou.familybudget.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import jp.rei.andou.familybudget.data.database.entites.FamilyAccount;
import jp.rei.andou.familybudget.data.database.entites.Salary;

@Dao
public abstract class AccountDao {

    @Insert
    public abstract long insertAccount(FamilyAccount account);

    @Insert
    public abstract long insertSalary(Salary salary);

}
