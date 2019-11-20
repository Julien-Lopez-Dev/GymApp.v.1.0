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
import androidx.navigation.Navigation;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceScreen;

import com.example.gymapp30.Startup.InputFragment;

public class SettingsPreferenceFragment extends PreferenceFragmentCompat {

    private String squatString;
    private String benchString;
    private String deadliftString;

    private EditTextPreference squatEtp;
    private EditTextPreference benchEtp;
    private EditTextPreference deadliftEtp;


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preference_screen, rootKey);

        //maybe set the sqedittext once depending if firstart or not using if prefs == false etc

        //load in input preferences as string or parse into int, into starting variables
        //save these preferences into new max variables, get & set
        //set these new values as string to the summary

        //calling shared prefs for input numbers & make EditText preferences

        //optimize the boolean first starts later ---> can be done without them
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        squatEtp = findPreference("maxSquat");
        benchEtp = findPreference("maxBench");
        deadliftEtp = findPreference("maxDeadlift");

        boolean firstStart = sharedPreferences.getBoolean("firstStart", true);
        if (firstStart == false){
            squatString = sharedPreferences.getString("squatIn", "");
            benchString = sharedPreferences.getString("benchIn", "");
            deadliftString = sharedPreferences.getString("deadliftIn", "");
            editor.putBoolean("firstStart2", true);
            editor.apply();
        }else {
            squatString = squatEtp.getText();
            benchString = benchEtp.getText();
            deadliftString = deadliftEtp.getText();
        }

        /*squatString = squatEtp.getText();
        benchString = benchEtp.getText();
        deadliftString = deadliftEtp.getText();*/

        squatEtp.setText(squatString);
        benchEtp.setText(benchString);
        deadliftEtp.setText(deadliftString);


       /* boolean firstStart = sharedPreferences.getBoolean("firstStart", true);
        if (firstStart == true){
            squatEtp.setText(sharedPreferences.getString("squatIn", ""));
            benchEtp.setText(sharedPreferences.getString("benchIn", ""));
            deadliftEtp.setText(sharedPreferences.getString("deadliftIn", ""));
        } else {

            squatEtp.setText("");
            benchEtp.setText("");
            deadliftEtp.setText("");
        }*/

        //can put into a switch or nested ifs in 1 change listener later

        Preference.OnPreferenceChangeListener squatChangeListener = new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                squatString = newValue.toString();
                squatEtp.setText(squatString);

                return false;
            }
        };

        Preference.OnPreferenceChangeListener benchChangeListener = new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                benchString = newValue.toString();
                benchEtp.setText(benchString);

                return false;
            }
        };

        Preference.OnPreferenceChangeListener deadliftChangeListener = new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                deadliftString = newValue.toString();
                deadliftEtp.setText(deadliftString);

                return false;
            }
        };

        squatEtp.setOnPreferenceChangeListener(squatChangeListener);
        benchEtp.setOnPreferenceChangeListener(benchChangeListener);
        deadliftEtp.setOnPreferenceChangeListener(deadliftChangeListener);



        if (squatEtp != null){
            squatEtp .setSummaryProvider(new Preference.SummaryProvider<EditTextPreference>() {
                @Override
                public CharSequence provideSummary(EditTextPreference preference) {
                    if (TextUtils.isEmpty(squatString)){
                        return "Not set";
                    }else
                        return squatString + "lbs";
                }
            });
        }

        if (benchEtp != null){
            benchEtp.setSummaryProvider(new Preference.SummaryProvider<EditTextPreference>() {
                @Override
                public CharSequence provideSummary(EditTextPreference preference) {
                    if (TextUtils.isEmpty(benchString)){
                        return "Not set";
                    }else
                        return benchString + "lbs";
                }
            });
        }

        if (deadliftEtp != null){
            deadliftEtp.setSummaryProvider(new Preference.SummaryProvider<EditTextPreference>() {
                @Override
                public CharSequence provideSummary(EditTextPreference preference) {
                    if (TextUtils.isEmpty(deadliftString)){
                        return "Not set";
                    }else
                        return deadliftString + "lbs";
                }
            });
        }

    }
}
