package com.example.trainingapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Plan {
    // Make sure not able to send null values from GUI
    private String planName; // test with and without final, best to use final if possible
    private List<Workout> workouts = new ArrayList<>(); // test with and without final, best to use final if possible

    private static AtomicInteger nextId = new AtomicInteger();
    private int id;

    public Plan(String planName) {
        id = nextId.incrementAndGet();
        this.planName = planName;
    }

    public List<Workout> getWorkoutList(){
        return workouts;
    }

    void removeWorkout(Workout workout) {
        workouts.remove(workout);
    }

    void addWorkout(Workout workout) {
        workouts.add(workout); // not sus
    }
    // method for changing workout?

    public int getId() {
        return id;
    }
}