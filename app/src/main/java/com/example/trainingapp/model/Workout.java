package com.example.trainingapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Workout {

    private String workoutName; // testa med och utan final, kör helst final
    private List<Exercise> exercises = new ArrayList<>(); // testa med och utan final, kör helst final
    private static AtomicInteger nextId = new AtomicInteger();
    private int id;

    public Workout(String workoutName) {
        id = nextId.incrementAndGet();
        this.workoutName = workoutName;
    }

    public String getName() {
        return workoutName;
    }

    public void addExercise(Exercise exercise) {
    exercises.add(exercise);
    }
    public List<Exercise> getExerciseList(){
        return exercises;
    }
}
