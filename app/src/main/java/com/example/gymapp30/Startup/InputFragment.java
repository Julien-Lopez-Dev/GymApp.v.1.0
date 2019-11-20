package com.example.gymapp30.Startup;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.gymapp30.R;

public class InputFragment extends Fragment {

    private SharedPreferences sharedPreferences;
    private Button setButton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.input_fragment, container, false);

        final EditText sqInput = root.findViewById(R.id.sqEditText);
        final EditText bnInput = root.findViewById(R.id.bnEditText);
        final EditText dlInput = root.findViewById(R.id.dlEditText);

        Button setButton = root.findViewById(R.id.setButton);




        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("squatIn", sqInput.getText().toString());
                editor.putString("benchIn", bnInput.getText().toString());
                editor.putString("deadliftIn", dlInput.getText().toString());



                editor.putBoolean("firstStart", true);
                editor.apply();


                Navigation.findNavController(v).navigate(R.id.action_inputFragment_to_homeFragment);
            }
        });




        return root;
    }
}
