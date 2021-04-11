package com.example.mobile.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.mobile.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements ProfileFragment.ProfileInterface, BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.browse);
    }

    ProfileFragment profileFragment = new ProfileFragment(this);


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.browse:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, new HomeFragment()).addToBackStack(null).commit();
                return true;

            case R.id.favorites:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, new FavoritesFragment()).addToBackStack(null).commit();
                return true;

            case R.id.profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, profileFragment).addToBackStack(null).commit();
                return true;
        }
        return false;
    }

    @Override
    public void swapToListing() {
        ListingResultsPagerFragment listingResultsFragment = new ListingResultsPagerFragment();
        listingResultsFragment.setIndex(0); // 0 for first position
        listingResultsFragment.setForHome(true);
        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, listingResultsFragment).commit();
        //setContentView(R.layout.activity_main);
        bottomNavigationView.getMenu().findItem(R.id.browse).setChecked(true);
    }
}
