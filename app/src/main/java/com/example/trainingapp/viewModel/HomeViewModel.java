package com.example.trainingapp.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * This is the "ViewModel" in the mvvm. The ViewModel is responsible for exposing (converting) the data
 * objects from the model in such a way that objects are easily managed and presented.
 * In this respect, the ViewModel is more model than view, and handles most if not all of the view's display logic.
 *
 * @author Valdemar Vålvik and Victor Hui
 */

public class HomeViewModel extends TrainingAppModelViewModel {

    /**
     * Variable for textView
     */

    private MutableLiveData<String> mText;

    /**
     * Class constructor
     */

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    /**
     * @return reference of mText variable
     */

    public LiveData<String> getText() {
        return mText;
    }


}