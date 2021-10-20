package com.example.trainingapp.model;

import com.example.trainingapp.mockDataBase.IDatabase;
import com.example.trainingapp.mockDataBase.MockDataBase;
import com.example.trainingapp.model.activeComponents.ActiveWorkout;
import com.example.trainingapp.model.activeComponents.ActiveWorkoutSession;
import com.example.trainingapp.model.components.Exercise;
import com.example.trainingapp.model.components.Plan;
import com.example.trainingapp.model.components.PlanBuilder;
import com.example.trainingapp.model.components.Workout;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The User-class act as a datahandler that connects all of the model with the modelfacade and the
 * database.
 */
public class TrainingAppFacade {

    /**
     * ActiveWorkoutSession-object to access logic for ActiveWorkout and ActiveExercise.
     */
    private final ActiveWorkoutSession activeWorkoutSession = new ActiveWorkoutSession();

    /**
     * ExerciseIdHandler-object for creating new exerciseId:s
     */
    private final ExerciseIdHandler exerciseIdHandler = new ExerciseIdHandler();

    /**
     * PlanBuilder-object for access to the modelcomponents (Exercise, Workout, Plan)
     */
    private final PlanBuilder planBuilder = new PlanBuilder();

    /**
     * User uses a MockDatabase to store plans, workouts and exercises
     * during runtime
     */
    private final IDatabase mockDataBase;

    /**
     * Class constructor
     *
     * @param mockDataBase
     */
    public TrainingAppFacade(IDatabase mockDataBase) {
        this.mockDataBase = mockDataBase;
    }

    /**
     * Method for returning a list of the stored plans from the database
     *
     * @return list of plans from database
     */
    public List<Plan> getSavedPlans(){
            return mockDataBase.getPlanList();
    }

    /**
     * Method for receiving the list of completed workouts from the database.
     *
     * @return the list of completed workouts.
     */
    public List<ActiveWorkout> getCompletedWorkouts() {return mockDataBase.getCompletedWorkouts();}

    /**
     * Method for removing the selected plan (first in list) from the database.
     */
    public void removePlan(String planId) {
        mockDataBase.removePlan(planId);
    }

    /**
     * Returns a new Plan-object
     *
     * @param planName the name of the plan
     */
    public void createNewPlan(){
        mockDataBase.addPlan(planBuilder.createNewPlan());
    }

    public void updatePlanName(String name, String id){
        mockDataBase.updatePlanName(name, id);
    }

    /**
     * Method for adding a workout to a plan
     *
     * @param plan the reference to the plan object
     * @param name the name of the Workout-object that gets added to the Plan
     */
    public void addWorkoutToPlan(String planId){
        mockDataBase.addWorkoutToPlan(planBuilder.createNewWorkout(), planId);
    }

    /**
     * Method for removing a workout from a plan
     *
     * @param plan the reference to the plan object
     * @param workout the reference to the workout object
     */
    public void removeWorkoutFromPlan(String planId, String workoutId) {
        mockDataBase.removeWorkoutFromPlan(planId, workoutId);
    }

    public void updateWorkoutName(String name, String planId, String workoutId){
        mockDataBase.updateWorkoutName(name, planId, workoutId);
    }

    /**
     * Method for adding an exercise to a workout
     *
     * @param workout the reference to the workout object
     * @param exerciseName the name of the exercise
     */
    public void addExerciseToWorkout(String planId, String workoutId) {
        mockDataBase.addExerciseToWorkout(planBuilder.createNewExercise(), planId, workoutId);
    }

    /**
     * Method for removing an exercise from a workout
     *
     * @param workout the reference to the Workout-object
     * @param exercise the Exercise-object to be removed
     */
    public void removeExerciseFromWorkout(String planId, String workoutId, String exerciseId){
        mockDataBase.removeExerciseFromWorkout(planId, workoutId, exerciseId);
    }

    public void updateExerciseName(String exerciseName, String planId, String workoutId, String exerciseId){
        mockDataBase.updateExerciseName(exerciseName, planId, workoutId, exerciseId);
    }
}
