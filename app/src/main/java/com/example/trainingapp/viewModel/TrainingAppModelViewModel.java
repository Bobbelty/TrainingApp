package com.example.trainingapp.viewModel;

import androidx.lifecycle.ViewModel;

import com.example.trainingapp.model.TrainingAppFacade;

public abstract class TrainingAppModelViewModel extends ViewModel {
    private static final TrainingAppFacade trainingAppModel = new TrainingAppFacade();

    protected final TrainingAppFacade getInstanceOfTrainingModel(){
        return trainingAppModel;
    }
}
