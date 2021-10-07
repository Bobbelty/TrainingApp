package com.example.trainingapp.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trainingapp.R;
import com.example.trainingapp.view.EditScheduleFragment;

public class TestActivity extends AppCompatActivity {

    public TestActivity() {
        super(R.layout.fragment_edit_schedule);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.container_view, EditScheduleFragment.class, null)
                    .commit();
        }

        /*
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_schedule, R.id.navigation_history, R.id.navigation_settings, R.id.navigation_workout)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        */
    }
}
