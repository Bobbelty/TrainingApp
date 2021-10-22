package com.example.trainingapp;

import org.junit.Test;

import com.example.trainingapp.model.TrainingAppFacade;
import com.example.trainingapp.mockDatabase.MockDatabase;
public class TrainingAppFacadeTest {

static TrainingAppFacade trainingAppFacade = new TrainingAppFacade(new MockDatabase());

    @Test
    public void testCreatingPlan() {
    trainingAppFacade.createNewPlan();
    assertFalse(trainingAppFacade.get);
    }

}
