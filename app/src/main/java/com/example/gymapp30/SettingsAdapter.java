package com.example.gymapp30;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.gymapp30.R;
import com.example.gymapp30.Startup.SettingsTitles;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SettingsAdapter extends ArrayAdapter<SettingsTitles> {

    private Context mContext;
    int mResource;


    public SettingsAdapter(@NonNull Context context, int resource, @NonNull List<SettingsTitles> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String title = getItem(position).getTitle();
        String hint = getItem(position).getHint();

        SettingsTitles settingsTitles = new SettingsTitles(title,hint);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.settingsTitle);
        TextView tvHint = (TextView) convertView.findViewById(R.id.settingsHint);

        tvTitle.setText(title);
        tvHint.setText(hint);

        return convertView;
    }
}
