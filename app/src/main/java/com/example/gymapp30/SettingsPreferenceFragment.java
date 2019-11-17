package com.example.gymapp30;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

public class SettingsPreferenceFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preference_screen, rootKey);
    }
}
