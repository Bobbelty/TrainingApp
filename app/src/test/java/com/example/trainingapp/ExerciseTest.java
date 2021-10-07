package com.example.trainingapp;

import com.example.trainingapp.model.Exercise;

import org.junit.Test;
import static org.junit.Assert.*;

public class ExerciseTest {
    /**
     * test if getName() works correctly.
     */
    @Test
    public void testGetName(){
        Exercise exercise = new Exercise("test", 123);
        assertEquals("test", exercise.getName());
    }

    /**
     * test if getId() works correctly.
     */
    @Test
    public void testGetId(){
        Exercise exercise = new Exercise("test", 123);
        assertEquals(123, exercise.getExerciseId());
    }

    @Test
    public void testAddReps(){
        int testRep1 = 1;
        int testRep2 = 2;
        Exercise exercise = new Exercise("test", 123);
        exercise.addSet(testRep1);
        exercise.addSet(testRep2);
        assertEquals(testRep2, (int) exercise.getReps().get(1));
    }




}
