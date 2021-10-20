package com.example.trainingapp.model;

import java.util.List;

/**
 * The TrainingApp-class purpose is to act as a facade of the model towards the ViewModels.
 * It communicates with a User-object, who in tern handles communication with the database
 * and the model.
 */
public class TrainingAppFacade {

    /**
     * An instance of the User-class. Used for communication with the rest of the model.
     */
    private User user = new User();

    /**
     * Used to get list of saved plans from the mockdatabase.
     *
     * @return list of saved plans
     */
    public List<Plan> getSavedPlans(){
        return user.getSavedPlans();
    }

    public List<ActiveWorkout> getCompletedWorkouts(){return user.getCompletedWorkouts();}

    /**
     * Method for creating a new Plan-object.
     *
     * @param planName the name for the new Plan-object
     */
    public void createNewPlan(String planName){
        user.createNewPlan(planName);
    }

    /**
     * Method for creating a new Workout-object and adding it to a specific Plan.
     *
     * @param plan which Plan-object to add the new Workout to
     * @param workoutName name of new workout-object
     */
    public void addWorkoutToPlan(Plan plan, String workoutName){
        user.addWorkoutToPlan(plan, workoutName);
    }

    /**
     * Method for removing a workout from a plan.
     *
     * @param plan the object which the workout will be removed from
     * @param workout what workout that will be removed
     */
    public void removeWorkoutFromPlan(Plan plan, Workout workout) {
        user.removeWorkoutFromPlan(plan, workout);
    }

    /**
     * Method for creating and adding a new Exercise-object to an existing workout.
     *
     * @param workout the workout to add exercise into
     * @param exerciseName name of the new exercise
     */
    public void addExerciseToWorkout(Workout workout, String exerciseName ){
        user.addExerciseToWorkout(workout,exerciseName);

    }
    public void removePlan(Plan selectedPlan) {
        user.removePlan(selectedPlan);
    }

    /**
     * Method for removing an exercise from a workout.
     *
     * @param workout which workout to remove exercise from
     * @param exercise which exercise to be removed
     */
    public void removeExerciseFromWorkout(Workout workout, Exercise exercise){
        user.removeExerciseFromWorkout(workout, exercise);
    }
                    /*if (selectedWorkout.getExerciseList().size() == 0) {
        List<Plan> plans = editScheduleViewModel.getTrainingAppModel().getSavedPlans();
        for (int i = 0; i < plans.size(); i++) {
            for (int k = 0; k < plans.get(i).getWorkoutList().size(); k++) {
                if (plans.get(i).getWorkoutList().get(k).equals(selectedWorkout)) {
                    plans.get(i).getWorkoutList().remove(k);
                }
            }
        }
*/



}
