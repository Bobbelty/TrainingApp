package com.example.trainingapp.model;

import java.util.List;

public class Exercise {

    String exerciseName;
    List<Integer> reps;

    public Exercise(String exerciseName, List<Integer> reps) {
        this.exerciseName = exerciseName;
        this.reps = reps;
    }
    @Override
    public String toString() {
        return exerciseName;
    }
}
