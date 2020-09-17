package xyz.spiral6.fitnesstracker.ui.settings;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import xyz.spiral6.fitnesstracker.R;

public class SettingsFragment extends PreferenceFragmentCompat {


    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}