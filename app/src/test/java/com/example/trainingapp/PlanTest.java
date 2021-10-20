package com.example.trainingapp;

import com.example.trainingapp.model.components.Plan;
import com.example.trainingapp.model.components.Workout;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlanTest {

    @Test
    public void testAddingWorkout(){
        Plan plan = new Plan("testPlan");
        Workout dummyWorkout = new Workout("dummyWorkout");
        plan.addWorkout(dummyWorkout);
        assertEquals(1, plan.getWorkoutList().size());

    }
}
