package com.example.trainingapp.ui.schedule;

import android.widget.Spinner;

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

public class ScheduleViewModel extends ViewModel {

    /**
     * Variable for textView
     */

    private MutableLiveData<String> mText;

    // Create an ArrayAdapter using the string array and a default spinner layout

    /**
     * Class constructor
     */

    public ScheduleViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is schedule fragment");
    }

    /**
     * @return reference of mText variable
     */

    public LiveData<String> getText() {
        return mText;
    }
}