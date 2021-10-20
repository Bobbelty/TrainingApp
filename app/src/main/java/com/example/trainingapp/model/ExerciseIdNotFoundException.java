package com.example.trainingapp.model;

public class ExerciseIdNotFoundException extends Exception{

    /**
     * Constructor for ExerciseIdNotFoundException
     * @param message The reason that caused the exception
     */
    public ExerciseIdNotFoundException(String message){
        super(message);
    }

}
