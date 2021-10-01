package com.example.trainingapp.model;

import java.util.List;

public class WorkoutFactory {
    public static Workout createWorkout(String name, List<Exercise> exerciseList){return new Workout(name, exerciseList);}
}
