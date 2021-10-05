package com.example.trainingapp.model;

import java.util.List;

public class ExerciseFactory {
    public static Exercise createExercise(String exerciseName, int exerciseId){return new Exercise(exerciseName, exerciseId);}
}
