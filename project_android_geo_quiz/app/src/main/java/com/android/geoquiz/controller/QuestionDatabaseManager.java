package com.android.geoquiz.controller;

import android.os.Bundle;

import com.android.geoquiz.model.QuestionDatabase;

public class QuestionDatabaseManager {

    private static final String KEY_INDEX = "KEY_INDEX";

    private QuestionDatabase questionDatabase;

    public QuestionDatabaseManager() {
        questionDatabase = new QuestionDatabase();
    }

    public QuestionDatabase getQuestionDatabase() {
        return questionDatabase;
    }

    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(KEY_INDEX, questionDatabase.getCurrentQuestionIndex());
    }

    public void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            int index = savedInstanceState.getInt(KEY_INDEX);
            questionDatabase.setCurrentQuestionIndex(index);
        }
    }

}
