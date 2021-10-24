package com.example.trainingapp.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trainingapp.R;
//import com.example.trainingapp.databinding.ActivityMainBinding;

/**
 * Activity for editing workouts during an active session
 */
public class EditWorkoutActivity extends AppCompatActivity {

    public EditWorkoutActivity() {
        super(R.layout.fragment_edit_activeworkout);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
