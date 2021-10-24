package com.example.trainingapp.model.components;

import com.example.trainingapp.model.components.Exercise;
import com.example.trainingapp.model.components.Workout;

import org.junit.Test;
import static org.junit.Assert.*;

public class WorkoutTest {


    @Test
    public void testUpdateExerciseNameWhenExerciseIdDoesNotExist(){
        Workout workout = new Workout();
        Exception exception = assertThrows(NullPointerException.class, () ->{
            workout.updateExerciseName("ThisIdDoesNotExist", "testName");
        });

        String expectedMessage = "No exercise with this Id exists";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testUpdateExerciseRepsWhenExerciseIdDoesNotExist(){
        Workout workout = new Workout();
        Exception exception = assertThrows(NullPointerException.class, () ->{
            workout.updateExerciseRep("ThisIdDoesNotExist", 12);
        });

        String expectedMessage = "No exercise with this Id exists";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testUpdateExerciseSetsWhenExerciseIdDoesNotExist(){
        Workout workout = new Workout();
        Exception exception = assertThrows(NullPointerException.class, () ->{
            workout.updateExerciseSets("ThisIdDoesNotExist", 4);
        });

        String expectedMessage = "No exercise with this Id exists";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
    
 

}
