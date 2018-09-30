package jp.rei.andou.familybudget.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.util.Log;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jp.rei.andou.familybudget.data.database.FinanceDatabase;
import jp.rei.andou.familybudget.data.database.dao.AccountDao;

@Module
public class DatabaseModule {

    private final FinanceDatabase database;

    public DatabaseModule(Context context) {
        fetchAssetDatabase(context);
        this.database = Room.databaseBuilder(
                context,
                FinanceDatabase.class,
                FinanceDatabase.DATABASE_NAME
        ).build(); //todo .openHelperFactory(new AssetSQLiteOpenHelperFactory())
    }

    /**
     * Fetch a default database from asset folder
     * if database file is already exists, so database is already fetched
     * @param applicationContext context of application
     */
    private void fetchAssetDatabase(Context applicationContext) {
        File databasePath = applicationContext.getDatabasePath(FinanceDatabase.DATABASE_NAME);
        if (databasePath.exists()) {
            return;
        }

        try (
                DataInputStream defaultDatabase = new DataInputStream(
                        applicationContext.getResources()
                                          .getAssets()
                                          .open(FinanceDatabase.DATABASE_NAME)
                );
                OutputStream databaseStream = new FileOutputStream(createDatabaseFile(databasePath))
        ){
            int byteCount = defaultDatabase.available();
            if (byteCount > 0) {
                byte[] bytes = new byte[byteCount];
                defaultDatabase.readFully(bytes);
                databaseStream.write(bytes);
            }
        } catch (IOException e) {
            Log.e("Database fetching", "FAILED WITH: " + e.getMessage());
        }
    }

    private File createDatabaseFile(File dbFile) throws IOException {
        if (dbFile.getParentFile().mkdirs() || dbFile.createNewFile()) {
            return dbFile;
        } else {
            throw new IOException("Не удалось создать файл базы данных");
        }
    }

    @Provides
    @Singleton
    FinanceDatabase provideDatabase() {
        return database;
    }

    @Provides
    @Singleton
    AccountDao provideAccountDao() {
        return database.getAccountDao();
    }

}
