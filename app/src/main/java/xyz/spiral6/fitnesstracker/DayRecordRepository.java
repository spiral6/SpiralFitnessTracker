package xyz.spiral6.fitnesstracker;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class DayRecordRepository {

    private DayRecordDao dayRecordDao;
    private LiveData<List<DayRecord>> allDayRecords;

    public DayRecordRepository(Application application) {
        DayRecordDatabase db = DayRecordDatabase.getDatabase(application);
        dayRecordDao = db.dayRecordDao();
        allDayRecords = dayRecordDao.getDayRecords();
    }

    public LiveData<List<DayRecord>> getAllDayRecords() {
        return this.allDayRecords;
    }

    public void insert(final DayRecord dr) {
        DayRecordDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dayRecordDao.insert(dr);
            }
        });
    }

}
