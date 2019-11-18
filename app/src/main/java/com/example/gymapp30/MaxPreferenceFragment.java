package com.example.gymapp30;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

public class MaxPreferenceFragment extends PreferenceFragmentCompat {



    String squatString;



    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preference_maxes, rootKey);


        EditTextPreference squatEditText = findPreference("squatIn");


        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE);
        squatString = sharedPreferences.getString("squatIn", "");


        SharedPreferences.Editor editor = sharedPreferences.edit();

        squatEditText.setText(squatString);



        if (squatEditText != null){
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

    }
}
