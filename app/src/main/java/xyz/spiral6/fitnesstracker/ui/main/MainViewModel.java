package xyz.spiral6.fitnesstracker.ui.main;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import xyz.spiral6.fitnesstracker.DayRecord;
import xyz.spiral6.fitnesstracker.DayRecordRepository;

public class MainViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel

    private DayRecordRepository repository;

    private LiveData<List<DayRecord>> allDayRecords;

    public MainViewModel (Application application) {
        super(application);
        repository = new DayRecordRepository(application);
        allDayRecords = repository.getAllDayRecords();
    }

    LiveData<List<DayRecord>> getAllDayRecords() {
        return allDayRecords;
    }

    public void insert(DayRecord dr) {
        repository.insert(dr);
    }

}