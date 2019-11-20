package com.example.gymapp30;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceScreen;

public class SettingsPreferenceFragment extends PreferenceFragmentCompat {

    private String squatString;
    private String benchString;
    private String deadliftString;


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preference_screen, rootKey);



        EditTextPreference squatEditText = findPreference("maxSquat");
        EditTextPreference benchEditText = findPreference("maxBench");
        EditTextPreference deadliftEditText = findPreference("maxDeadlift");


        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE);
        squatString = sharedPreferences.getString("squatIn", "");
        benchString = sharedPreferences.getString("benchIn", "");
        deadliftString = sharedPreferences.getString("deadliftIn", "");

        squatEditText.setText(squatString);
        benchEditText.setText(benchString);
        deadliftEditText.setText(deadliftString);

        squatEditText.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                squatEditText.setText("CHANGED");

                Toast.makeText(getActivity(), "Works", Toast.LENGTH_LONG);
                return true;
            }
        });


        /*if (squatEditText != null){
            squatEditText.setSummaryProvider(new Preference.SummaryProvider<EditTextPreference>() {
                @Override
                public CharSequence provideSummary(EditTextPreference preference) {
                    if (TextUtils.isEmpty(squatString)){
                        return "Not set";
                    }else
                        return squatString + "lbs";
                }
            });
        }

        if (benchEditText != null){
            squatEditText.setSummaryProvider(new Preference.SummaryProvider<EditTextPreference>() {
                @Override
                public CharSequence provideSummary(EditTextPreference preference) {
                    if (TextUtils.isEmpty(benchString)){
                        return "Not set";
                    }else
                        return benchString + "lbs";
                }
            });
        }

        if (deadliftEditText != null){
            squatEditText.setSummaryProvider(new Preference.SummaryProvider<EditTextPreference>() {
                @Override
                public CharSequence provideSummary(EditTextPreference preference) {
                    if (TextUtils.isEmpty(deadliftString)){
                        return "Not set";
                    }else
                        return deadliftString + "lbs";
                }
            });
        }*/

    }
}
