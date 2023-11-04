package com.example.toursimapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Replace the initial fragment with HomeFragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new HomeFragment())
                    .commit();
        }
    }

    public void showLocationDetails(String locationName, String locationDescription) {
        // Replace the current fragment with LocationFragment when a button is clicked
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, LocationFragment.newInstance(locationName, locationDescription));
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
