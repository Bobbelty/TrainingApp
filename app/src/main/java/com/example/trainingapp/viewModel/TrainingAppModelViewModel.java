package com.example.trainingapp.viewModel;

import androidx.lifecycle.ViewModel;

import com.example.trainingapp.model.TrainingApp;

public abstract class TrainingAppModelViewModel extends ViewModel {
    private static final TrainingApp trainingAppModel = new TrainingApp();

    protected final TrainingApp getInstanceOfTrainingModel(){
        return trainingAppModel;
    }
}
