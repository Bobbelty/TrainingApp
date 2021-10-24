package com.example.trainingapp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.example.trainingapp.model.TrainingAppFacade;
import com.example.trainingapp.mockDatabase.MockDatabase;
import com.example.trainingapp.model.activeComponents.ActiveWorkout;
import com.example.trainingapp.model.activeComponents.ActiveWorkoutSession;
import com.example.trainingapp.model.components.Exercise;
import com.example.trainingapp.model.activeComponents.ActiveExercise;
import com.example.trainingapp.model.components.Plan;
import com.example.trainingapp.model.components.Workout;

import java.util.List;

public class TrainingAppFacadeTest {
    static TrainingAppFacade trainingAppFacade;
    static ActiveWorkoutSession activeWorkoutSession;

    @Before
    public void init() {
        trainingAppFacade = new TrainingAppFacade(new MockDatabase());
        clearDatabase(trainingAppFacade);
    }

    private void clearDatabase(TrainingAppFacade trainingAppFacade1){
        for(Plan plan : trainingAppFacade1.getSavedPlans() ){
            trainingAppFacade1.removePlan(plan.getId());
        }
    }

    @Test
    public void testGetSavedPlans() {
        trainingAppFacade.createNewPlan();
        trainingAppFacade.createNewPlan();
        trainingAppFacade.createNewPlan();
        assertEquals(3, trainingAppFacade.getSavedPlans().size());
    }

    @Test
    public void testCreatePlan() {
        assertEquals(0, trainingAppFacade.getSavedPlans().size());
        trainingAppFacade.createNewPlan();
        trainingAppFacade.createNewPlan();
        assertEquals(2, trainingAppFacade.getSavedPlans().size());
    }

    @Test
    public void testRemovePlan() {
        trainingAppFacade.createNewPlan();
        trainingAppFacade.createNewPlan();
        trainingAppFacade.createNewPlan();
        assertEquals(3, trainingAppFacade.getSavedPlans().size());
        List<Plan> list = trainingAppFacade.getSavedPlans();
        Plan plan = trainingAppFacade.getSavedPlans().get(0);
        trainingAppFacade.removePlan(plan.getId());
        assertEquals(2, trainingAppFacade.getSavedPlans().size());
    }


    @Test
    public void testGetPlan() {
        trainingAppFacade.createNewPlan();
        Plan plan = trainingAppFacade.getSavedPlans().get(0);
        trainingAppFacade.updatePlanName("updatedPlan", plan.getId());
        Plan updatedPlan = trainingAppFacade.getSavedPlans().get(0);
        Plan planFromMap = trainingAppFacade.getPlan(updatedPlan.getId());
        assertEquals(updatedPlan.getPlanName(), planFromMap.getPlanName());
    }

    @Test
    public void testGetPlanWhenPlanIdDoesNotExist(){
        Exception exception = assertThrows(NullPointerException.class, () ->{
            trainingAppFacade.getPlan("ThisIdDoesNotExist");
        });

        String expectedMessage = "No plan with this Id exists";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testUpdatePlanName() {
        trainingAppFacade.createNewPlan();

        Plan plan = trainingAppFacade.getSavedPlans().get(0);
        trainingAppFacade.updatePlanName("updatedPlanName", plan.getId());
        assertEquals("updatedPlanName", trainingAppFacade.getPlan(plan.getId()).getPlanName());
    }

    @Test
    public void testUpdatePlanNameWhenPlanIdDoesNotExist(){
        Exception exception = assertThrows(NullPointerException.class, () ->{
            trainingAppFacade.updatePlanName("updatedPlanName", "ThisIdDoesNotExist");
        });

        String expectedMessage = "No plan with this Id exists";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testAddWorkoutToPlan() {
        trainingAppFacade.createNewPlan();
        Plan plan = trainingAppFacade.getSavedPlans().get(0);
        assertEquals(0,plan.getWorkoutList().size());
        trainingAppFacade.createNewWorkout(plan.getId());
        Plan updatedPlan = trainingAppFacade.getSavedPlans().get(0);
        assertEquals(1, updatedPlan.getWorkoutList().size());


    }

    @Test
    public void testAddWorkoutToPlanWhenPlanIdDoesNotExist(){
        Exception exception = assertThrows(NullPointerException.class, () ->{
            trainingAppFacade.createNewWorkout("ThisIdDoesNotExist");
        });

        String expectedMessage = "No plan with this Id exists";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testRemoveWorkoutFromPlan() {
        trainingAppFacade.createNewPlan();
        Plan plan = trainingAppFacade.getSavedPlans().get(0);
        trainingAppFacade.createNewWorkout(plan.getId());
        Workout workout = trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0);
        assertEquals(1, trainingAppFacade.getSavedPlans().get(0).getWorkoutList().size());

        trainingAppFacade.removeWorkoutFromPlan(plan.getId(), workout.getId());
        assertEquals(0, trainingAppFacade.getSavedPlans().get(0).getWorkoutList().size());
    }

    @Test
    public void testRemoveWorkoutFromPlanWhenPlanIdDoesNotExist(){
        Exception exception = assertThrows(NullPointerException.class, () ->{
            trainingAppFacade.removeWorkoutFromPlan("ThisIdDoesNotExist", "ThisIdDoesNotExist2");
        });

        String expectedMessage = "No plan with this Id exists";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }


    @Test
    public void testUpdateWorkoutName() {
        trainingAppFacade.createNewPlan();
        List<Plan> list = trainingAppFacade.getSavedPlans();
        Plan plan = trainingAppFacade.getSavedPlans().get(0);
        trainingAppFacade.createNewWorkout(plan.getId());
        Workout workout = trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0);
        trainingAppFacade.updateWorkoutName("updatedWorkoutName", plan.getId(), workout.getId());
        assertEquals("updatedWorkoutName", trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0).getName());
    }

    @Test
    public void testUpdateWorkoutNameWhenPlanIdDoesNotExist(){
        Exception exception = assertThrows(NullPointerException.class, () ->{
            trainingAppFacade.updateWorkoutName("updatedWorkoutName","ThisIdDoesNotExist", "ThisIdDoesNotExist2");
        });

        String expectedMessage = "No plan with this Id exists";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }


    @Test
    public void testAddExerciseToWorkout() {
        trainingAppFacade.createNewPlan();
        Plan plan = trainingAppFacade.getSavedPlans().get(0);
        trainingAppFacade.createNewWorkout(plan.getId());
        Workout workout = trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0);
        assertEquals(0, workout.getExerciseList().size());

        trainingAppFacade.addExerciseToWorkout(plan.getId(), workout.getId());
        Workout updatedWorkout = trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0);
        assertEquals(1, updatedWorkout.getExerciseList().size());

    }
    @Test
    public void testAddExerciseToWorkoutWhenPlanIdDoesNotExist(){
        Exception exception = assertThrows(NullPointerException.class, () ->{
            trainingAppFacade.addExerciseToWorkout("ThisIdDoesNotExist","ThisIdDoesNotExist2");
        });

        String expectedMessage = "No plan with this Id exists";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }



    @Test
    public void testRemoveExerciseFromWorkout() {
        trainingAppFacade.createNewPlan();
        Plan plan = trainingAppFacade.getSavedPlans().get(0);
        trainingAppFacade.createNewWorkout(plan.getId());
        Workout workout = trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0);
        trainingAppFacade.addExerciseToWorkout(plan.getId(), workout.getId());
        assertEquals(1, workout.getExerciseList().size());

        Exercise exercise = trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0).getExerciseByIndex(0);
        trainingAppFacade.removeExerciseFromWorkout(plan.getId(), workout.getId(), exercise.getId());
        Workout updatedWorkout = trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0);
        assertEquals(0, updatedWorkout.getExerciseList().size());
    }

    @Test
    public void testRemoveExerciseFromWorkoutWhenPlanIdDoesNotExist(){
        Exception exception = assertThrows(NullPointerException.class, () ->{
            trainingAppFacade.removeExerciseFromWorkout("ThisIdDoesNotExist","ThisIdDoesNotExist2", "ThisIdDoesNotExist3");
        });

        String expectedMessage = "No plan with this Id exists";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testUpdateExerciseName(){
        trainingAppFacade.createNewPlan();
        Plan plan = trainingAppFacade.getSavedPlans().get(0);
        trainingAppFacade.createNewWorkout(plan.getId());
        Workout workout = trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0);
        assertEquals(0, workout.getExerciseList().size());

        trainingAppFacade.addExerciseToWorkout(plan.getId(), workout.getId());
        Workout updatedWorkout = trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0);
        assertEquals(1, updatedWorkout.getExerciseList().size());

        Exercise exercise = trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0).getExerciseByIndex(0);
        assertEquals("New Exercise", exercise.getName());

        trainingAppFacade.updateExerciseName( plan.getId(), workout.getId(), exercise.getId(), "updatedExerciseName");
        Exercise updatedExercise = trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0).getExerciseByIndex(0);
        assertEquals("updatedExerciseName", updatedExercise.getName());
    }

    @Test
    public void testUpdateExerciseNameWhenPlanIdDoesNotExist(){
        Exception exception = assertThrows(NullPointerException.class, () ->{
            trainingAppFacade.updateExerciseName("ThisIdDoesNotExist", "ThisIdDoesNotExist2" ,"ThisIdDoesNotExist3"
            , "newExerciseName");
        });

        String expectedMessage = "No plan with this Id exists";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }


    @Test
    public void testUpdateExerciseRep() {
        trainingAppFacade.createNewPlan();
        Plan plan = trainingAppFacade.getSavedPlans().get(0);
        trainingAppFacade.createNewWorkout(plan.getId());
        Workout workout = trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0);
        assertEquals(0, workout.getExerciseList().size());

        trainingAppFacade.addExerciseToWorkout(plan.getId(), workout.getId());
        Workout updatedWorkout = trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0);
        assertEquals(1, updatedWorkout.getExerciseList().size());

        Exercise exercise = trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0).getExerciseByIndex(0);
        assertEquals(0, exercise.getNumberOfReps());

        trainingAppFacade.updateExerciseRep(12, plan.getId(), workout.getId(), exercise.getId());
        Exercise updatedExercise = trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0).getExerciseByIndex(0);
        assertEquals(12, updatedExercise.getNumberOfReps());
    }

    @Test
    public void testUpdateExerciseRepWhenPlanIdDoesNotExist(){
        Exception exception = assertThrows(NullPointerException.class, () ->{
            trainingAppFacade.updateExerciseRep(2,"ThisIdDoesNotExist", "ThisIdDoesNotExist2" ,"ThisIdDoesNotExist3"
                    );
        });

        String expectedMessage = "No plan with this Id exists";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testUpdateExerciseSets() {
        trainingAppFacade.createNewPlan();
        Plan plan = trainingAppFacade.getSavedPlans().get(0);
        trainingAppFacade.createNewWorkout(plan.getId());
        Workout workout = trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0);
        assertEquals(0, workout.getExerciseList().size());

        trainingAppFacade.addExerciseToWorkout(plan.getId(), workout.getId());
        Workout updatedWorkout = trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0);
        assertEquals(1, updatedWorkout.getExerciseList().size());

        Exercise exercise = trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0).getExerciseByIndex(0);
        assertEquals(0, exercise.getNumberOfSets());

        trainingAppFacade.updateExerciseSets(4, plan.getId(), workout.getId(), exercise.getId());
        Exercise updatedExercise = trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0).getExerciseByIndex(0);
        assertEquals(4, updatedExercise.getNumberOfSets());
    }

    @Test
    public void testUpdateExerciseSetsWhenPlanIdDoesNotExist(){
        Exception exception = assertThrows(NullPointerException.class, () ->{
            trainingAppFacade.updateExerciseSets(2,"ThisIdDoesNotExist", "ThisIdDoesNotExist2" ,"ThisIdDoesNotExist3"
            );
        });

        String expectedMessage = "No plan with this Id exists";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testConvertWorkoutToActiveWorkout() {
        trainingAppFacade.createNewPlan();
        Plan plan = trainingAppFacade.getSavedPlans().get(0);
        trainingAppFacade.createNewWorkout(plan.getId());
        Workout workout = trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0);
        trainingAppFacade.addExerciseToWorkout(plan.getId(), workout.getId());
        Exercise exercise = trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0).getExerciseByIndex(0);
        trainingAppFacade.updateExerciseSets(2, plan.getId(), workout.getId(), exercise.getId());
        trainingAppFacade.convertWorkoutToActive(plan.getId(), workout.getId());
        assertEquals("0", trainingAppFacade.getActiveWorkout().getTime());
        assertEquals(0, trainingAppFacade.getActiveWorkout().getExercise(0).getWeights(), 0.01);
    }

    @Test
    public void testUpdateActiveExerciseRep() {
        trainingAppFacade.createNewPlan();
        Plan plan = trainingAppFacade.getSavedPlans().get(0);
        trainingAppFacade.createNewWorkout(plan.getId());
        Workout workout = trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0);
        trainingAppFacade.addExerciseToWorkout(plan.getId(), workout.getId());
        Exercise exercise = trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0).getExerciseByIndex(0);
        trainingAppFacade.updateExerciseSets(2, plan.getId(), workout.getId(), exercise.getId());
        trainingAppFacade.convertWorkoutToActive(plan.getId(), workout.getId());
        ActiveExercise activeExercise = trainingAppFacade.getActiveWorkout().getExercise(0);
        trainingAppFacade.updateActiveExerciseRep(12, activeExercise.getExerciseId());
        assertEquals(12, activeExercise.getNoOfReps());
    }

    @Test
    public void testAddToHistory() {
        trainingAppFacade.createNewPlan();
        Plan plan = trainingAppFacade.getSavedPlans().get(0);
        trainingAppFacade.createNewWorkout(plan.getId());
        Workout workout = trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0);
        trainingAppFacade.addExerciseToWorkout(plan.getId(), workout.getId());
        Exercise exercise = trainingAppFacade.getSavedPlans().get(0).getWorkoutList().get(0).getExerciseByIndex(0);
        trainingAppFacade.updateExerciseSets(2, plan.getId(), workout.getId(), exercise.getId());
        trainingAppFacade.convertWorkoutToActive(plan.getId(), workout.getId());
        ActiveExercise activeExercise = trainingAppFacade.getActiveWorkout().getExercise(0);
        trainingAppFacade.updateActiveExerciseRep(12, activeExercise.getExerciseId());
        trainingAppFacade.endActiveWorkout();
        List<ActiveWorkout> completedWorkouts = trainingAppFacade.getCompletedWorkouts();
        assertEquals(3, completedWorkouts.size());
    }

}
