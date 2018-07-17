package com.android.geoquiz.model;

import com.android.geoquiz.R;

import java.util.ArrayList;
import java.util.List;

public class QuestionDatabase {

    private List<Question> questions;

    public QuestionDatabase() {
        questions = new ArrayList<>();
        questions.add(new Question(R.string.question1, true));
//        questions.add(new Question(R.string.question2, false));
//        questions.add(new Question(R.string.question3, false));
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
