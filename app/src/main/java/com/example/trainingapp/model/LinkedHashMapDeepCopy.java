package com.example.trainingapp.model;

import com.example.trainingapp.model.activeComponents.ActiveExercise;
import com.example.trainingapp.model.components.Exercise;
import com.example.trainingapp.model.components.Workout;
import java.util.*;
import java.lang.Object;

import java.util.LinkedHashMap;

public class LinkedHashMapDeepCopy {

    public static LinkedHashMap<String, Workout> deepCopyWorkoutMap(LinkedHashMap<String, Workout> workoutMap) {
        LinkedHashMap<String,Workout> deepCopy = new LinkedHashMap<>();
        for(LinkedHashMap.Entry<String,Workout> entry : workoutMap.entrySet()) {
            deepCopy.put(entry.getKey(), entry.getValue().clone());
        }
        return deepCopy;
    }

    public static LinkedHashMap<String, Exercise> deepCopyExerciseMap(LinkedHashMap<String, Exercise> exerciseMap) {
        LinkedHashMap<String,Exercise> deepCopy = new LinkedHashMap<>();
        for(LinkedHashMap.Entry<String,Exercise> entry : exerciseMap.entrySet()) {
            deepCopy.put(entry.getKey(), entry.getValue().clone());
        }
        return deepCopy;
    }

    public static LinkedHashMap<String, ActiveExercise> deepCopyActiveExerciseMap(LinkedHashMap<String, ActiveExercise> activeExerciseMap) {
        LinkedHashMap<String,ActiveExercise> deepCopy = new LinkedHashMap<>();
        for(LinkedHashMap.Entry<String,ActiveExercise> entry : activeExerciseMap.entrySet()) {
            deepCopy.put(entry.getKey(), entry.getValue().clone());
        }
        return deepCopy;
    }

}
