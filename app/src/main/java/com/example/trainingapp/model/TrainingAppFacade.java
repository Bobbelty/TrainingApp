package com.example.trainingapp.model;

import java.util.List;

/**
 * The TrainingApp-class purpose is to act as a facade of the model towards the ViewModels.
 * It contains method for communication with the database. Furthermore it can access the model
 * through a PlanBuilder-object.
 */
public class TrainingAppFacade {
    private User user = new User();


    public List<Plan> getSavedPlans(){
        return user.getSavedPlans();
    }
    public void createNewPlan(String planName){
        user.createNewPlan(planName);
    }

    public void addWorkoutToPlan(Plan plan, String workoutName){
        user.addWorkoutToPlan(plan, workoutName);
    }

    public void removeWorkoutFromPlan(Plan plan, Workout workout) {
        user.removeWorkoutFromPlan(plan, workout);
    }

    public void addExerciseToWorkout(Workout workout, String exerciseName ){
        user.addExerciseToWorkout(workout,exerciseName);

    }
    public void removePlan(Plan selectedPlan) {
        user.removePlan(selectedPlan);
    }

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
