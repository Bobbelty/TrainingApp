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
 * @author Valdemar Vålvik and Victor Hui
 */

public class EditScheduleViewModel extends TrainingAppModelViewModel{

    /**
     * Variable for textView
     */

    private MutableLiveData<String> mText;
    private TrainingAppFacade trainingAppModel;
    private Workout selectedWorkout;
    private Plan selectedPlan;

    public String getSelectedPlanId() {
        return selectedPlanId;
    }

    public void setSelectedPlanId(String selectedPlanId) {
        this.selectedPlanId = selectedPlanId;
    }

    private String selectedPlanId;

    private static EditScheduleViewModel instance = null;

    // Create an ArrayAdapter using the string array and a default spinner layout

    /**
     * Class constructor
     */

    private EditScheduleViewModel() {

        mText = new MutableLiveData<>();
        mText.setValue("This is schedule fragment");

        trainingAppModel = getInstanceOfTrainingModel();
    }

    public void onClickRemoveExercise(String planId, String workoutId, String exerciseId) {
        trainingAppModel.removeExerciseFromWorkout(planId, workoutId, exerciseId);
        //getTrainingAppModel().removeExerciseFromWorkout(selectedWorkout, selectedWorkout.getExerciseList().get(position));
    }
    public void removeWorkout(String planId, String workoutId) {
        trainingAppModel.removeWorkoutFromPlan(planId, workoutId);
        //getTrainingAppModel().removeWorkoutFromPlan(selectedPlan, selectedWorkout);
    }
    public void setNewNoOfSets(int position, String noOfSets) {
        // Set
        selectedWorkout.getExerciseList().get(position).setNumberOfSets(Integer.parseInt(noOfSets));
    }
    public void setNewNoOfReps(int position, String noOfReps) {
        selectedWorkout.getExerciseList().get(position).setNumberOfReps(Integer.parseInt(noOfReps));
    }
    public void setNewExerciseName(String exerciseName, String planId, String workoutId, String exerciseId) {
        trainingAppModel.updateExerciseName(exerciseName, planId, workoutId, exerciseId);
        //selectedWorkout.getExerciseList().get(position).setName(exerciseName);
    }
    public void setNewWorkoutName(String newWorkoutName, String planId, String workoutId) {
        trainingAppModel.updateWorkoutName(newWorkoutName, planId, workoutId);
        //selectedWorkout.setName(newWorkoutName);
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