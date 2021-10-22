package com.example.trainingapp.model.components;

import com.example.trainingapp.model.components.Exercise;

import org.junit.Test;
import static org.junit.Assert.*;

public class ExerciseTest {
    /**
     * test if getName() works correctly.
     */
    @Test
    public void testGetName(){
        Exercise exercise = new Exercise("test");
        assertEquals("test", exercise.getName());
    }



    @Test
    public void testAddRepsAndSets(){
        int reps = 12;
        int sets = 4;
        Exercise exercise = new Exercise("test");
        exercise.setNumberOfReps(reps);
        exercise.setNumberOfSets(sets);
        assertEquals(reps, exercise.getNumberOfReps());
        assertEquals(sets, exercise.getNumberOfSets());
    }
}
