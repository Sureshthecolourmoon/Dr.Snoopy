package com.example.drsnoopy.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.drsnoopy.Fragments.DoctorFragment;
import com.example.drsnoopy.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class DoctorActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemReselectedListener {
    BottomNavigationView bottomNavigationView;


    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        bottomNavigationView = findViewById(R.id.bottomnavigation);
        bottomNavigationView.setOnNavigationItemReselectedListener(this);
        if (savedInstanceState == null) {
            bottomNavigationView.setSelectedItemId(R.id.home);
        }
    }


    @Override
    public void onNavigationItemReselected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home) {
            loadFragment(new DoctorFragment());
        } else if (id == R.id.appointment) {
            if (id == R.id.notification) {
                if (id == R.id.accounts) {

                }
            }
        }

    }

    private void loadFragment(DoctorFragment doctorFragment) {
        if (doctorFragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.doctor_frame, doctorFragment)
                    .addToBackStack("tag")
                    .commit();
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    @Override
    public void onBackPressed() {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.doctor_frame);
        if (currentFragment instanceof DoctorFragment) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

}