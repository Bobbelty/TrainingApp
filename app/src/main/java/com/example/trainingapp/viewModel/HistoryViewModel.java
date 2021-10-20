package com.example.trainingapp.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.trainingapp.model.ActiveWorkout;
import com.example.trainingapp.model.TrainingAppFacade;
import com.example.trainingapp.model.Workout;

/**
 * This is the "ViewModel" in the mvvm. The ViewModel is responsible for exposing (converting) the data
 * objects from the model in such a way that objects are easily managed and presented.
 * In this respect, the ViewModel is more model than view, and handles most if not all of the view's display logic.
 *
 * @author Valdemar Vålvik and Victor Hui
 */

public class HistoryViewModel extends TrainingAppModelViewModel {


    private TrainingAppFacade trainingAppModel;
    private ActiveWorkout selectedActiveWorkout;

    private static HistoryViewModel instance = null;

    /**
     * Variable for textView
     */
    private MutableLiveData<String> mText;

    /**
     * Class constructor
     */
    public HistoryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is history fragment");

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
    public static HistoryViewModel getInstance() {
        if (instance == null) {
            instance = new HistoryViewModel();
            return instance;
        }
        else {
            return instance;
        }
    }

    public ActiveWorkout getSelectedWorkout() {
        return selectedActiveWorkout;
    }
    public void setSelectedWorkout(ActiveWorkout selectedActiveWorkout) {
        this.selectedActiveWorkout = selectedActiveWorkout;
    }
}
