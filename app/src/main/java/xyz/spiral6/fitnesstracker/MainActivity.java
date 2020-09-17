package xyz.spiral6.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import xyz.spiral6.fitnesstracker.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }
}