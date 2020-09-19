package xyz.spiral6.fitnesstracker;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "day_records")
public class DayRecord {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "date")
    private String date;

    @TypeConverters(WorkoutConverter.class)
    private Workout[] workouts;

    private int calories;

    public Workout[] getWorkouts() {
        return workouts;
    }

    public int getCalories() {
        return calories;
    }

    @NonNull
    public String getDate() {
        return date;
    }

    public DayRecord(@NonNull String date, @NonNull Workout[] workouts, int calories) {
        this.date = date;
        this.workouts = workouts;
        this.calories = calories;
    }

    @Ignore
    public DayRecord(){
        this.date = "";
        this.workouts = new Workout[]{};
        this.calories = 0;
    }
}

class WorkoutConverter {
    @TypeConverter
    public static Workout[] toWorkouts(String workouts) {
        Gson gson = new Gson();
        Workout[] result = gson.fromJson(workouts, Workout[].class);
        return result;
    }

    @TypeConverter
    public static String toWorkoutsString(Workout[] workouts){
        Gson gson = new Gson();
        return gson.toJson(workouts);
    }
}

class Workout {
    @Override
    public String toString() {
        Gson gson = new Gson();
//        return "Workout{" +
//                "name='" + name + '\'' +
//                ", repetitions=" + repetitions +
//                ", sets=" + sets +
//                '}';
        return gson.toJson(this);
    }

    private String name;
    private int repetitions;
    private int sets;

    public Workout (@NonNull String name, int repetitions, int sets){
        this.name = name;
        this.repetitions = repetitions;
        this.sets = sets;
    }



}