package com.apms_user;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView bottomNavView;
    private FrameLayout frameLayout;
    private DashboardFragment dashboardFragment;
    private ProfileFragment profileFragment;
    private HistoryFragment historyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavView = findViewById(R.id.nav_view);
        frameLayout = findViewById(R.id.bottom_nav_frame);
        dashboardFragment = new DashboardFragment();
        profileFragment = new ProfileFragment();
        historyFragment = new HistoryFragment();

        setFragment(dashboardFragment);
        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.dashboard:
                        setFragment(dashboardFragment);
                        return true;
                    case R.id.history:
                        setFragment(historyFragment);
                        return true;
                    case R.id.profile:
                        setFragment(profileFragment);
                        return true;
                }
                return false;
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.bottom_nav_frame, fragment);
        fragmentTransaction.commit();

    }
}
