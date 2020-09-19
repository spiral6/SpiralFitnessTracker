package xyz.spiral6.fitnesstracker;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {DayRecord.class}, version = 1, exportSchema = false)
public abstract class DayRecordDatabase extends RoomDatabase {

    public abstract DayRecordDao dayRecordDao();

    private static volatile  DayRecordDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static DayRecordDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DayRecordDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DayRecordDatabase.class, "day_records_database").build();
                }
            }
        }
        return INSTANCE;
    }

}
