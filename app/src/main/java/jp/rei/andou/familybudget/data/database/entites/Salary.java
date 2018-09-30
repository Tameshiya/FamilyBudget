package jp.rei.andou.familybudget.data.database.entites;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import lombok.Getter;
import lombok.Setter;

@Entity(tableName = "salaries")
@Getter
@Setter
public class Salary {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private long units;
    private long subunits;
    private String currencyCode;

}
