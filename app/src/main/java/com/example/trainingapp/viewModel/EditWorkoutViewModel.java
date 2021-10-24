package com.example.trainingapp.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.trainingapp.model.TrainingAppFacade;
import com.example.trainingapp.model.activeComponents.ActiveWorkout;
import com.example.trainingapp.model.components.Plan;

import com.example.trainingapp.model.components.Workout;

import java.util.List;

/**
 * This is the "ViewModel" in the mvvm. The ViewModel is responsible for exposing (converting) the data
 * objects from the model in such a way that objects are easily managed and presented.
 * In this respect, the ViewModel is more model than view, and handles most if not all of the view's display logic.
 *
 * @author Philip Rabia and Patrik Olsson
 */

public class EditWorkoutViewModel extends TrainingAppModelViewModel{

    /**
     * Variable for textView
     */
    private final MutableLiveData<String> mText;

    /**
     * Variable for the Facade
     */
    private final TrainingAppFacade trainingAppModel;


    /**
     * Variable used to access various workouts
     */
    private Workout selectedWorkout;

    /**
     * The Plan selected in Schedule part of application
     */
    private Plan selectedPlan;

    /**
     * Variable for Singleton
     */
    private static EditWorkoutViewModel instance = null;

    /**
     * Class constructor
     */
    private EditWorkoutViewModel() {

        mText = new MutableLiveData<>();
        mText.setValue("This is schedule fragment");

        trainingAppModel = getInstanceOfTrainingModel();
    }

    /**
     * endActiveWorkout calls endActiveWorkout in the model
     *
     */
    public void endActiveWorkout() {
        trainingAppModel.endActiveWorkout();
    }

    /**
     * updateActiveExerciseReps updates the number of reps of the activeExercise
     *
     * @param reps number of reps
     * @param exerciseId id of the excersice
     */
    public void updateActiveExerciseReps(int reps, String exerciseId) {
        trainingAppModel.updateActiveExerciseRep(reps, exerciseId);
    }

    /**
     * updateActiveExerciseWeight updates weight of the activeExercise
     *
     * @param weight
     * @param exerciseId id of the excersice
     */
    public void updateActiveExerciseWeight(double weight, String exerciseId) {
        trainingAppModel.updateActiveExerciseWeight(exerciseId, weight);
    }

    /**
     * createActiveWorkout creates an activeWorkout
     *
     * @param workoutId id of the workout
     * @param planId id of the plan
     */
    public void createActiveWorkout(String planId, String workoutId){
        trainingAppModel.convertWorkoutToActive(planId, workoutId);
    }

    /**
     * getActiveWorkout gets the active workout from the model
     *
     * @returns an active workout
     */
    public ActiveWorkout getActiveWorkout() {
        return trainingAppModel.getActiveWorkout();
    }

    /**
     * getSavedPlans gets the saved plans from the database
     *
     * @returns a list of plans
     */
    public List<Plan> getSavedPlans() {
        return trainingAppModel.getSavedPlans();
    }

    /**
     * addExerciseToWorkout adds an exercise to a workout
     *
     * @param workoutId id of the workout
     * @param planId id of the plan
     */
    public void addExerciseToWorkout(String planId, String workoutId) {
        trainingAppModel.createNewExercise(planId, workoutId);
    }

    /**
     * onClickRemoveExercise removes the selected exercise from the workout
     *
     * @param workoutId id of the workout
     * @param planId id of the plan
     * @param exerciseId id of the exercise
     */
    public void onClickRemoveExercise(String planId, String workoutId, String exerciseId) {
        trainingAppModel.removeExerciseFromWorkout(planId, workoutId, exerciseId);
    }

    /**
     * removeWorkoutFromPlan removes the selected workout from plan
     *
     * @param workoutId id of the workout
     * @param planId id of the plan
     */
    public void removeWorkoutFromPlan(String planId, String workoutId) {
        trainingAppModel.removeWorkoutFromPlan(planId, workoutId);
    }

    /**
     * setNewNoOfSets changes the number of sets of an exercise
     *
     * @param noOfSets number of sets
     * @param planId id of the plan
     * @param workoutId id of the workout
     * @param exerciseId id of the exercise
     */
    public void setNewNoOfSets(int noOfSets, String planId, String workoutId, String exerciseId) {
        trainingAppModel.updateExerciseSets(noOfSets, planId, workoutId, exerciseId);
    }

    /**
     * setNewNoOfReps changes the number of reps of an exercise
     *
     * @param noOfReps number of reps
     * @param planId id of the plan
     * @param workoutId id of the workout
     * @param exerciseId id of the exercise
     */
    public void setNewNoOfReps(int noOfReps, String planId, String workoutId, String exerciseId) {
        trainingAppModel.updateExerciseRep(noOfReps, planId, workoutId, exerciseId);
    }

    /**
     * setNewExerciseName changes the name of the exercise
     *
     * @param exerciseName the new name of the exercise
     * @param planId id of the plan
     * @param workoutId id of the workout
     * @param exerciseId id of the exercise
     */
    public void setNewExerciseName(String exerciseName, String planId, String workoutId, String exerciseId) {
        trainingAppModel.updateExerciseName(exerciseName, planId, workoutId, exerciseId);
    }

    /**
     * Set a new name of a workout
     * @param newWorkoutName the new workout name
     * @param planId plan id
     * @param workoutId workout id
     */
    public void setNewWorkoutName(String newWorkoutName, String planId, String workoutId) {
        trainingAppModel.updateWorkoutName(newWorkoutName, planId, workoutId);
    }

    /**
     * @return reference of mText variable
     */
    public LiveData<String> getText() {
        return mText;
    }

    public TrainingAppFacade getTrainingAppModel(){
        return trainingAppModel;
    }

    /**
     * Method enforcing singleton on ViewModel, sending current reference of ViewModel if
     * it is otherwise creating a new instance
     */
    public static EditWorkoutViewModel getInstance() {
        if (instance == null) {
            instance = new EditWorkoutViewModel();
            return instance;
        }
        else {
            return instance;
        }
    }

    /**
     * @param planId plan identifier
     * @param workoutId workout identifier
     * @return returns a copy of the workout from a plan by the identif
     */
    public Workout getWorkoutById(String planId, String workoutId) {
        return trainingAppModel.getWorkout(planId, workoutId);
    }

    /**
     * @return returns the selected workout
     */
    public Workout getSelectedWorkout() {
        return selectedWorkout;
    }

    /**
     * Select a workout
     * @param selectedWorkout workout to set as selected
     */
    public void setSelectedWorkout(Workout selectedWorkout) {
        this.selectedWorkout = selectedWorkout;
    }

    /**
     * @return returns the selected plan
     */
    public Plan getSelectedPlan() {
        return selectedPlan;
    }

    /**
     * Select a plan
     * @param selectedPlan plan to set as selected
     */
    public void setSelectedPlan(Plan selectedPlan) {
        this.selectedPlan = selectedPlan;
    }
}