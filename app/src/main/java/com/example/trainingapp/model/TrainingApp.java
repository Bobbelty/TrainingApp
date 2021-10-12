package com.example.trainingapp.model;

import com.example.trainingapp.mockDataBase.MockDataBase;

import java.util.List;

/**
 * The TrainingApp-class purpose is to act as a facade of the model towards the ViewModels.
 * It contains method for communication with the database. Furthermore it can access the model
 * through a PlanBuilder-object.
 */
public class TrainingApp {

    /**
     * PlanBuilder-object for access to the model
     */
    private final PlanBuilder planBuilder = new PlanBuilder();

    /**
     * TrainingApp uses a MockDatabase to store plans, workouts and exercises
     * during runtime
     */
    private final MockDataBase mockDataBase = new MockDataBase();

    /**
     * Method for returning a list of the stored plans from the database
     *
     * @return list of plans from database
     */
    public List<Plan> getMockData(){
        return mockDataBase.getPlanList();
    }

    /**
     * Method for adding a workout to a plan
     *
     * @param plan the reference to the plan object
     * @param name the name of the Workout-object that gets added to the Plan
     */
    public void addWorkoutToPlan(Plan plan, String name){
        planBuilder.addWorkoutToPlan(plan, name);
    }

    /**
     * Returns a new Plan-object
     *
     * @param planName the name of the plan
     */
    public void createNewPlan(String planName){
        mockDataBase.addPlan(planBuilder.createNewPlan(planName));
    }

    /**
     * Method for removing a workout from a plan
     *
     * @param plan the reference to the plan object
     * @param workout the reference to the workout object
     */
    public void removeWorkoutFromPlan(Plan plan, Workout workout) {
        planBuilder.removeWorkoutFromPlan(plan, workout);
    }

    /**
     * Method for adding an exercise to a workout
     *
     * @param workout the reference to the workout object
     * @param exerciseName the name of the exercise
     */
    public void addExerciseToWorkout(Workout workout, String exerciseName) {
        try{
            int exerciseId = mockDataBase.getExerciseIdFromMap(exerciseName);
            planBuilder.addExerciseToWorkout(workout, exerciseName, exerciseId);
        } catch (ExerciseIdNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for removing an exercise from a workout
     *
     * @param workout the reference to the Workout-object
     * @param exercise the Exercise-object to be removed
     */
    public void removeExerciseFromWorkout(Workout workout, Exercise exercise){
        planBuilder.removeExerciseFromWorkout(workout, exercise);
    }
}
