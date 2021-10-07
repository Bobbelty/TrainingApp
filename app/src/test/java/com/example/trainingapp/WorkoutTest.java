package com.example.trainingapp;

import com.example.trainingapp.model.Exercise;
import com.example.trainingapp.model.Workout;

import org.junit.Test;
import static org.junit.Assert.*;

public class WorkoutTest {

    @Test
    public void testGetNameCorrect(){
        Workout workout = new Workout("test");
        assertEquals("test", workout.getName());
    }

    @Test
    public void testAddExerciseIsCorrect(){
        Workout workout = new Workout("test");
        Exercise dummyExercise = new Exercise("testexcercise",123);
        workout.addExercise(dummyExercise);
        assertFalse(workout.getExerciseList().isEmpty());

    }

}
