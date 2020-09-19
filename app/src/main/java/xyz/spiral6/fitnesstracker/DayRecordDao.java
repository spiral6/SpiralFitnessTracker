package xyz.spiral6.fitnesstracker;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DayRecordDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(DayRecord dr);

    @Delete
    void deleteDayRecord(DayRecord dr);

    @Query("SELECT * FROM day_records ORDER BY date ASC")
    LiveData<List<DayRecord>> getDayRecords();
}
