package com.example.trainingapp.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.trainingapp.model.TrainingAppFacade;

/**
 * This is the "ViewModel" in the mvvm. The ViewModel is responsible for exposing (converting) the data
 * objects from the model in such a way that objects are easily managed and presented.
 * In this respect, the ViewModel is more model than view, and handles most if not all of the view's display logic.
 *
 * @author Valdemar Vålvik and Victor Hui
 */

public class ScheduleViewModel extends TrainingAppModelViewModel{

    /**
     * Variable for textView
     */

    private MutableLiveData<String> mText;
    private TrainingAppFacade trainingAppModel;

    // Create an ArrayAdapter using the string array and a default spinner layout

    /**
     * Class constructor
     */

    public ScheduleViewModel() {
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
}