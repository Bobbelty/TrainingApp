package com.example.trainingapp.model;

import java.util.List;

public class WorkoutFactory {
    public static Workout createWorkout(String name){return new Workout(name);}
}
