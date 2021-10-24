package com.example.trainingapp.model.components;

import com.example.trainingapp.model.components.Plan;
import com.example.trainingapp.model.components.Workout;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlanTest {

    @Test
    public void testGetWorkoutWhenWorkoutIdDoesNotExist(){
        Plan plan = new Plan();
        Exception exception = assertThrows(NullPointerException.class, () ->{
            plan.getWorkoutById("ThisIdDoesNotExist");
        });

        String expectedMessage = "No workout with this Id exists";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testUpdateWorkoutNameWhenWorkoutIdDoesNotExist(){
        Plan plan = new Plan();
        Exception exception = assertThrows(NullPointerException.class, () ->{
            plan.updateWorkoutName("newName", "ThisWorkoutIdDoesNotExist");
        });

        String expectedMessage = "No workout with this Id exists";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

    }


    @Test
    public void testAddExerciseToWorkoutWhenWorkoutIdDoesNotExist(){
        Plan plan = new Plan();
        Exercise exercise = new Exercise();
        Exception exception = assertThrows(NullPointerException.class, () ->{
            plan.addExerciseToWorkout(exercise, "ThisIdDoesNotExist");
        });

        String expectedMessage = "No workout with this Id exists";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void testRemoveExerciseFromWorkoutWhenWorkoutIdDoesNotExist(){
        Plan plan = new Plan();
        Exercise exercise = new Exercise();
        Exception exception = assertThrows(NullPointerException.class, () ->{
            plan.removeExerciseFromWorkout("ThisIdDoesNotExist", "ThisIdDoesNotExist2");
        });

        String expectedMessage = "No workout with this Id exists";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void testUpdateExerciseNameWhenWorkoutIdDoesNotExist(){
        Plan plan = new Plan();
        Exception exception = assertThrows(NullPointerException.class, () ->{
            plan.updateExerciseName("ThisIdDoesNotExist","ThisIdDoesNotExist2" ,"testName");
        });

        String expectedMessage = "No workout with this Id exists";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testUpdateExerciseRepsWhenWorkoutIdDoesNotExist(){
        Plan plan = new Plan();
        Exception exception = assertThrows(NullPointerException.class, () ->{
            plan.updateExerciseRep("ThisIdDoesNotExist","ThisIdDoesNotExist2" ,12);
        });

        String expectedMessage = "No workout with this Id exists";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testUpdateExerciseSetsWhenWorkoutIdDoesNotExist(){
        Plan plan = new Plan();
        Exception exception = assertThrows(NullPointerException.class, () ->{
            plan.updateExerciseSets("ThisIdDoesNotExist","ThisIdDoesNotExist2" ,3);
        });

        String expectedMessage = "No workout with this Id exists";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }


}
