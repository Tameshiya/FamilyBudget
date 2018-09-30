package jp.rei.andou.familybudget.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import jp.rei.andou.familybudget.data.database.converters.DateConverter;
import jp.rei.andou.familybudget.data.database.dao.AccountDao;
import jp.rei.andou.familybudget.data.database.entites.FamilyAccount;
import jp.rei.andou.familybudget.data.database.entites.Payment;
import jp.rei.andou.familybudget.data.database.entites.PaymentsType;
import jp.rei.andou.familybudget.data.database.entites.Salary;

@Database(version = 1, entities = {Payment.class, FamilyAccount.class, PaymentsType.class, Salary.class})
@TypeConverters(DateConverter.class)
public abstract class FinanceDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "finances_database";

    public abstract AccountDao getAccountDao();
}
