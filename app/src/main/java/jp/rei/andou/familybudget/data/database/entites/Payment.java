package jp.rei.andou.familybudget.data.database.entites;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Entity(tableName = "payments")
@Getter
@Setter
public class Payment {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private long cost;
    @ForeignKey(entity = PaymentsType.class, childColumns = "typeId", parentColumns = "id")
    private int typeId;
    private String name;
    private String description;
    @ForeignKey(entity = FamilyAccount.class, childColumns = "accountId", parentColumns = "id")
    private long accountId;
    private Date planDate;

}
