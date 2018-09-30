package jp.rei.andou.familybudget.data.database.entites;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import lombok.Getter;
import lombok.Setter;

@Entity(tableName = "payments_types")
@Getter
@Setter
public class PaymentsType {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;

}
