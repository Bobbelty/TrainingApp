package com.example.trainingapp.model;

import java.util.List;

public class WorkoutPlanFactory {
    public static Plan createPlan(String name){return new Plan(name);}
    public static Workout createWorkout(String name){return new Workout(name);}
    public static Exercise createExercise(String exerciseName, int exerciseId){return new Exercise(exerciseName, exerciseId);}
}
