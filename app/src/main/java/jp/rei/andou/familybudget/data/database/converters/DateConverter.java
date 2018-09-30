package jp.rei.andou.familybudget.data.database.converters;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class DateConverter {

    @TypeConverter
    public Date convertToDate(long millis) {
        return new Date(millis);
    }

    @TypeConverter
    public long convertFromDate(Date date) {
        return date.getTime();
    }

}
