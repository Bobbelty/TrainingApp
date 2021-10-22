package com.example.trainingapp.viewModel;

import android.widget.EditText;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.trainingapp.model.TrainingAppFacade;
import com.example.trainingapp.model.components.Plan;

import com.example.trainingapp.model.components.Workout;

/**
 * This is the "ViewModel" in the mvvm. The ViewModel is responsible for exposing (converting) the data
 * objects from the model in such a way that objects are easily managed and presented.
 * In this respect, the ViewModel is more model than view, and handles most if not all of the view's display logic.
 *
 * @author Philip Rabia and Patrik Olsson
 */

public class EditScheduleViewModel extends TrainingAppModelViewModel{

    /**
     * Variable for textView
     */
    private final MutableLiveData<String> mText;
    private final TrainingAppFacade trainingAppModel;
    private Workout selectedWorkout;
    private Plan selectedPlan;

    private static EditScheduleViewModel instance = null;

    /**
     * Class constructor
     */
    private EditScheduleViewModel() {

        mText = new MutableLiveData<>();
        mText.setValue("This is schedule fragment");

        trainingAppModel = getInstanceOfTrainingModel();
    }
    public void addExerciseToWorkout(String planId, String workoutId) {
        trainingAppModel.addExerciseToWorkout(planId, workoutId);
    }
    public void onClickRemoveExercise(String planId, String workoutId, String exerciseId) {
        trainingAppModel.removeExerciseFromWorkout(planId, workoutId, exerciseId);
    }
    public void removeWorkoutFromPlan(String planId, String workoutId) {
        trainingAppModel.removeWorkoutFromPlan(planId, workoutId);
    }
    public void setNewNoOfSets(int noOfSets, String planId, String workoutId, String exerciseId) {
        trainingAppModel.updateExerciseSets(noOfSets, planId, workoutId, exerciseId);
    }
    public void setNewNoOfReps(int noOfReps, String planId, String workoutId, String exerciseId) {
        trainingAppModel.updateExerciseRep(noOfReps, planId, workoutId, exerciseId);
    }
    public void setNewExerciseName(String exerciseName, String planId, String workoutId, String exerciseId) {
        trainingAppModel.updateExerciseName(exerciseName, planId, workoutId, exerciseId);
    }
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

    public static EditScheduleViewModel getInstance() {
        if (instance == null) {
            instance = new EditScheduleViewModel();
            return instance;
        }
        else {
            return instance;
        }
    }
    public Workout getWorkoutById(String planId, String workoutId) {
        return trainingAppModel.getWorkout(planId, workoutId);
    }
    public Workout getSelectedWorkout() {
        return selectedWorkout;
    }
    public void setSelectedWorkout(Workout selectedWorkout) {
        this.selectedWorkout = selectedWorkout;
    }
    public Plan getSelectedPlan() {
        return selectedPlan;
    }
    public void setSelectedPlan(Plan selectedPlan) {
        this.selectedPlan = selectedPlan;
    }
}