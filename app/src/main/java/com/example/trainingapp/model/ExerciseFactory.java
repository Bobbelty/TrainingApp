package com.example.trainingapp.model;

import java.util.List;

public class ExerciseFactory {
    public static Exercise createExercise(String exerciseName, List<Integer> sets){return new Exercise(exerciseName, sets);}
}
