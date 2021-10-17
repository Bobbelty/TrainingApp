package com.example.trainingapp.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.trainingapp.model.ActiveWorkout;
import com.example.trainingapp.model.TrainingAppFacade;

public class ExerciseHistoryViewModel extends TrainingAppModelViewModel {

    private MutableLiveData<String> mText;
    private TrainingAppFacade trainingAppModel;
    private ActiveWorkout selectedActiveWorkout;

    private static ExerciseHistoryViewModel instance = null;


    private ExerciseHistoryViewModel() {

        mText = new MutableLiveData<>();
        mText.setValue("This is Exercise History fragment");

        trainingAppModel = getInstanceOfTrainingModel();
    }

    public LiveData<String> getText() {
        return mText;
    }


    public TrainingAppFacade getTrainingAppModel(){
        return trainingAppModel;
    }

    public static ExerciseHistoryViewModel getInstance() {
        if (instance == null) {
            instance = new ExerciseHistoryViewModel();
            return instance;
        }
        else {
            return instance;
        }
    }

    public ActiveWorkout getSelectedWorkout() {
        return selectedActiveWorkout;
    }
    public void setSelectedWorkout(ActiveWorkout selectedWorkout) {
        this.selectedActiveWorkout = selectedWorkout;
    }
}
