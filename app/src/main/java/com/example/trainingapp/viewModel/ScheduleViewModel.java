package com.example.trainingapp.viewModel;

import android.widget.EditText;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.trainingapp.model.TrainingAppFacade;
import com.example.trainingapp.model.components.Plan;

import java.util.List;

/**
 * This is the "ViewModel" in the mvvm. The ViewModel is responsible for exposing (converting) the data
 * objects from the model in such a way that objects are easily managed and presented.
 * In this respect, the ViewModel is more model than view, and handles most if not all of the view's display logic.
 *
 * @author Philip Rabia, Patrik Olsson and Oscar Wallin
 */

public class ScheduleViewModel extends TrainingAppModelViewModel{

    /**
     * Variable for textView
     */

    private MutableLiveData<String> mText;
    private TrainingAppFacade trainingAppModel;

    /**
     * Class constructor
     */

    /**
     * @return returns a list of saved plans
     */
    public List<Plan> getSavedPlans() {
        return trainingAppModel.getSavedPlans();
    }

    /**
     * addPlan adds a plan to the user's database
     */
    public void addPlan() {
        trainingAppModel.createNewPlan();
    }

    /**
     * Searches the database to find the correct plan
     * @param planId identifier for a plan
     * @return returns a copy of the plan
     */
    public Plan getPlanById(String planId) {
        return trainingAppModel.getPlan(planId);
    }

    /**
     * Removes the plan
     * @param selectedPlan plan to remove
     */
    public void removePlan(Plan selectedPlan) {
        trainingAppModel.removePlan(selectedPlan.getId());
    }

    /**
     * Method for setting a new plan name through the EditText window, using nested loop for
     * finding the plan to change
     *
     * @param selectedPlan the current selected plan
     * @param etbxPlanName the EditText window
     * @param planList the list of plans
     */
    public void setNewPlanName(Plan selectedPlan, EditText etbxPlanName, List<Plan> planList) {
        trainingAppModel.updatePlanName(etbxPlanName.getText().toString(), selectedPlan.getId());
        for (int i = 0; i < planList.size(); i++) {
            List<Plan> databaseList = getTrainingAppModel().getSavedPlans();
            for (int k = 0; k < databaseList.size(); k++) {
                if (databaseList.get(k).getId().equals(planList.get(i).getId())) {
                    planList.get(i).setPlanName(databaseList.get(k).getPlanName());
                }
            }
        }
    }

    /**
     * Method for pushing the latest plan to the top of list as to display its content on creation
     *
     * @param planList the list of plans
     */
    public void shiftRight(List<Plan> planList)
    {
        Plan temp = planList.get(planList.size()-1);

        for(int i = planList.size()-1; i > 0; i--)
        {
            planList.set(i,planList.get(i-1));
        }
        planList.set(0, temp);
    }

    /**
     * Constructor for the viewModel
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