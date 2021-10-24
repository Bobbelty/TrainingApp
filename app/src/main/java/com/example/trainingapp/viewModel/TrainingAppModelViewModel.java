package com.example.trainingapp.viewModel;

import androidx.lifecycle.ViewModel;

import com.example.trainingapp.mockDatabase.MockDatabase;
import com.example.trainingapp.model.TrainingAppFacade;


/**
 * TrainingAppModelViewModel is the abstract ViewModel for the respective ViewModels used in the
 * application, providing the TrainingAppFacade and the corresponding getter.
 *
 * @author Valdemar Vålvik and Victor Hui
 */
public abstract class TrainingAppModelViewModel extends ViewModel {
    private static final TrainingAppFacade trainingAppModel = new TrainingAppFacade(new MockDatabase());

    protected final TrainingAppFacade getInstanceOfTrainingModel(){
        return trainingAppModel;
    }
}
