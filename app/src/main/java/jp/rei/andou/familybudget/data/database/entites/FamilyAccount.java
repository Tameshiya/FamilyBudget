package jp.rei.andou.familybudget.data.database.entites;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import lombok.Getter;
import lombok.Setter;

@Entity(tableName = "family_accounts")
@Getter
@Setter
public class FamilyAccount {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    @ForeignKey(entity = Salary.class, childColumns = "salaryId", parentColumns = "id")
    private long salaryId;

}
