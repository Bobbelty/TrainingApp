package com.example.trainingapp;

import com.example.trainingapp.model.components.Exercise;
import com.example.trainingapp.model.components.Workout;

import org.junit.Test;
import static org.junit.Assert.*;

public class WorkoutTest {


    @Test
    public void testAddingExercise(){
        Workout workout = new Workout("testWorkout");
        Exercise dummyExercise = new Exercise("dummyExcercise",123);
        workout.addExercise(dummyExercise);
        assertEquals(1, workout.getExerciseList().size());

    }

    @Test
    public void testRemovingExercise(){
        Workout workout = new Workout("testWorkout");
        Exercise dummyExercise = new Exercise("dummyExcercise",123);
        workout.addExercise(dummyExercise);
        workout.removeExercise(dummyExercise);
        assertTrue(workout.getExerciseList().isEmpty());

    }

}
