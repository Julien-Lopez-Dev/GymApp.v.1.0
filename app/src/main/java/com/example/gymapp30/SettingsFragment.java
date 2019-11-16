package com.example.gymapp30;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gymapp30.Startup.SettingsTitles;

import java.util.ArrayList;


public class SettingsFragment extends Fragment {

    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.settings_fragment, container, false);


        ListView listView = root.findViewById(R.id.listView);

        //objects
        SettingsTitles startingDate = new SettingsTitles("Starting Date", "Edit your start date");
        SettingsTitles oneRepMax = new SettingsTitles("One Rep Maxes", "Edit your maxes");
        SettingsTitles weightIncrement = new SettingsTitles("Weight Increments", "Edit your weight increments");



        ArrayList<SettingsTitles> settings = new ArrayList<>();
        settings.add(startingDate);
        settings.add(oneRepMax);
        settings.add(weightIncrement);

        SettingsAdapter adapter = new SettingsAdapter(getActivity(), R.layout.settings_list_adapter, settings);
        listView.setAdapter(adapter);

        return root;
    }

}
