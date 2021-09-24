package com.example.trainingapp.model;

import java.util.List;

public class Workout {

    private String workoutName; // testa med och utan final, kör helst final
    private List<Exercise> exercises; // testa med och utan final, kör helst final

    public Workout(String workoutName, List<Exercise> exercises) {
        this.workoutName = workoutName;
        this.exercises = exercises;
    }
    public String getName() {
        return workoutName;
    }
}
