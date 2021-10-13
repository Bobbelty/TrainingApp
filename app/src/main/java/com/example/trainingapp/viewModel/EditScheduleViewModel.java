package com.example.trainingapp.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.trainingapp.model.TrainingAppFacade;
import com.example.trainingapp.model.Workout;

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
}