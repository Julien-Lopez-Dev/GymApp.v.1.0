package com.example.gymapp30;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;



/*
*   Fri 11/15/19 - Added bottom nav and inputs and set the first startup components
*                  to both of the startup fragments using shared prefs.
*                  & Added listview in the settings fragment via adapter -- need to update look etc
*
*                  Need to update values of inputFrag into SharedPref into Settings Frag
*                  & create Progress Frag and add to bottomNav
*                  & set Calendar Views + View Models
*
*
*
*
*
*
*
*
*
*
*
 */


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);







        //BottomNav Visibility
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if(destination.getId() == R.id.welcomeFragment || destination.getId() == R.id.inputFragment) {
                    bottomNavigationView.setVisibility(View.GONE);
                } else {
                    bottomNavigationView.setVisibility(View.VISIBLE);
                }

            }
        });

        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}
