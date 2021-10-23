package com.example.trainingapp.model;

import com.example.trainingapp.mockDatabase.IDatabase;
import com.example.trainingapp.model.activeComponents.ActiveWorkout;
import com.example.trainingapp.model.activeComponents.ActiveWorkoutSession;
import com.example.trainingapp.model.components.Plan;
import com.example.trainingapp.model.components.PlanComponentFactory;
import com.example.trainingapp.model.components.Workout;

import java.util.List;

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
     * The facade uses a MockDatabase to store plans, workouts and exercises
     * during runtime. It also stores completed workouts.
     */
    private final IDatabase mockDataBase;

    /**
     * Class constructor initiating the database
     *
     * @param mockDataBase the programs database
     */
    public TrainingAppFacade(IDatabase mockDataBase) {
        this.mockDataBase = mockDataBase;
    }

    /**
     * Method for returning a copy of the list of saved plans from the database
     *
     * @return list of saved plans from database
     */
    public List<Plan> getSavedPlans() throws NullPointerException{
            return mockDataBase.getPlanList();
    }

    /**
     * Method for getting a copy of the plan from the database
     *
     * @param planId the id of the plan
     *
     * @return copy of the specified plan object
     */
    public Plan getPlan(String planId) throws NullPointerException{
        return mockDataBase.getPlan(planId);
    }

    /**
     * Method for receiving the copy of the list with completed workouts from the database.
     *
     * @return the list of completed workouts.
     */
    public List<ActiveWorkout> getCompletedWorkouts() {return mockDataBase.getCompletedWorkouts();}

    /**
     * Method for removing a specific plan from the database.
     */
    public void removePlan(String planId) {
        mockDataBase.removePlan(planId);
    }
    /**
     * Adds a new Plan-object to the database
     */
    public void createNewPlan(){
        mockDataBase.addPlan(PlanComponentFactory.createPlan());
    }

    /**
     * Updates a specific plans name
     *
     * @param name the new name
     * @param id the id of the desired plan
     */
    public void updatePlanName(String name, String id) throws NullPointerException{
        mockDataBase.updatePlanName(name, id);
    }

    /**
     * Method for adding a workout to a plan
     *
     * @param planId what plan to add it into
     */
    public void createNewWorkout(String planId) throws NullPointerException{
        mockDataBase.addWorkoutToPlan(PlanComponentFactory.createWorkout(), planId);
    }

    /**
     * Method for removing a workout from a plan
     *
     * @param planId in which plan
     * @param workoutId which workout to remove
     */
    public void removeWorkoutFromPlan(String planId, String workoutId) throws NullPointerException{
        mockDataBase.removeWorkoutFromPlan(planId, workoutId);
    }

    /**
     * Method for getting a specified workout
     *
     * @param planId the Id for the plan
     * @param workoutId the Id for the workout
     */
    public Workout getWorkout(String planId, String workoutId) throws NullPointerException {
        return mockDataBase.getWorkout(planId, workoutId);
    }
    /**
     * Updates the name of a specific workout
     *
     * @param name the new name
     * @param planId in which plan
     * @param workoutId which workout to update
     */
    public void updateWorkoutName(String name, String planId, String workoutId) throws NullPointerException{
        mockDataBase.updateWorkoutName(name, planId, workoutId);
    }

    /**
     * Method for adding an exercise to a workout
     *
     * @param planId in which plan
     * @param workoutId in which workout
     */
    public void addExerciseToWorkout(String planId, String workoutId) throws NullPointerException {
        mockDataBase.addExerciseToWorkout(PlanComponentFactory.createExercise(), planId, workoutId);
    }

    /**
     * Method for getting the current activeWorkout
     *
     * @return the current activeWorkout
     */
    public ActiveWorkout getActiveWorkout() {
        return mockDataBase.getActiveWorkout();
    }

    /**
     * Method for removing an exercise from a workout
     *
     * @param planId in which plan
     * @param workoutId in which workout
     * @param exerciseId which exercise to remove
     */
    public void removeExerciseFromWorkout(String planId, String workoutId, String exerciseId) throws NullPointerException{
        mockDataBase.removeExerciseFromWorkout(planId, workoutId, exerciseId);
    }

    /**
     * Method for updating the name of an exercise
     *
     * @param exerciseName the new name
     * @param planId in which plan
     * @param workoutId in which workout
     * @param exerciseId what exercise to update
     */
    public void updateExerciseName(String planId, String workoutId, String exerciseId, String exerciseName) throws NullPointerException{
        mockDataBase.updateExerciseName(planId, workoutId, exerciseId, exerciseName);
    }

    /**
     * Method for updating the reps in an exercise
     *
     * @param reps the new number of reps
     * @param planId the Id for the plan
     * @param workoutId the Id for the workout
     * @param exerciseId the Id for the exercise
     */
    public void updateExerciseRep(int reps, String planId, String workoutId, String exerciseId) throws NullPointerException{
        mockDataBase.updateExerciseRep(reps, planId, workoutId, exerciseId);
    }

    /**
     * Method for updating the sets in an exercise
     *
     * @param sets the new number of sets
     * @param planId the Id for the plan
     * @param workoutId the Id for the workout
     * @param exerciseId the Id for the exercise
     */
    public void updateExerciseSets(int sets, String planId, String workoutId, String exerciseId) throws NullPointerException{
        mockDataBase.updateExerciseSets(sets, planId, workoutId, exerciseId);
    }

    /**
     * Method for convert a workout to an activeWorkout
     *
     * @param planId the Id for the plan
     * @param workoutId the Id for the workout
     */
    public void convertWorkoutToActive(String planId, String workoutId) throws NullPointerException{
        mockDataBase.newActiveWorkout(planId, workoutId);
    }


    /**
     * Method for updating a rep in an active exercise
     *
     * @param reps the new amount of reps
     * @param exerciseId the Id for the exercise
     */
    public void updateActiveExerciseRep(int reps, String exerciseId){
        mockDataBase.updateActiveExerciseRep(reps, exerciseId);
    }

    /**
     * Method for updating the weight for a set in the exercise
     *
     * @param exerciseId the Id for the exercise
     * @param weight the new weight value
     */
    public void updateActiveExerciseWeight(String exerciseId, double weight){
        mockDataBase.updateActiveExerciseWeight(exerciseId, weight);
    }

    /**
     * Method for ending an active workout
     */
    public void endActiveWorkout(){
        mockDataBase.endActiveWorkout();
    }
    
}
