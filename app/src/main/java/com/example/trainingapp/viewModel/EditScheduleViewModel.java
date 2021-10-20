package com.example.trainingapp.viewModel;

import android.widget.EditText;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.trainingapp.model.Exercise;
import com.example.trainingapp.model.Plan;

import com.example.trainingapp.model.TrainingAppFacade;
import com.example.trainingapp.model.Workout;
import com.example.trainingapp.view.Adapter.EditScheduleRecyclerViewAdapter;

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

    public void onClickRemoveExercise(Plan selectedPlan, Workout selectedWorkout, int position) {
        getTrainingAppModel().removeExerciseFromWorkout(selectedWorkout, selectedWorkout.getExerciseList().get(position));
    }
    public void removeWorkout(Plan selectedPlan, Workout selectedWorkout) {
        getTrainingAppModel().removeWorkoutFromPlan(selectedPlan, selectedWorkout);
    }
    public void setNewNoOfSets(int position, EditText etbxNoOfSets) {
        selectedWorkout.getExerciseList().get(position).setNumberOfSets(Integer.parseInt(etbxNoOfSets.getText().toString()));
    }
    public void setNewNoOfReps(int position, EditText etbxNoOfReps) {
        selectedWorkout.getExerciseList().get(position).setNumberOfReps(Integer.parseInt(etbxNoOfReps.getText().toString()));
    }
    public void setNewExerciseName(int position, EditText etbxExerciseName) {
        selectedWorkout.getExerciseList().get(position).setName(etbxExerciseName.getText().toString());
    }
    public void setNewWorkoutName(EditText etbxWorkoutName) {
        selectedWorkout.setWorkoutName(etbxWorkoutName.getText().toString());
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