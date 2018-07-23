package com.android.geoquiz.model;

import com.android.geoquiz.R;

import java.util.ArrayList;
import java.util.List;

public class QuestionDatabase {

    private List<Question> questions;
    private int currentQuestionIndex;

    public QuestionDatabase() {
        questions = new ArrayList<>();
        questions.add(new Question(R.string.question1, true));
        questions.add(new Question(R.string.question2, false));
        questions.add(new Question(R.string.question3, false));
        currentQuestionIndex = 0;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public void setCurrentQuestionIndex(int currentQuestionIndex) {
        this.currentQuestionIndex = currentQuestionIndex;
    }

    public void changeQuestionIndexBy(int value) {
//        currentQuestionIndex = (currentQuestionIndex + value) % questions.size();
        currentQuestionIndex += value;
        if (currentQuestionIndex >= questions.size()) {
            currentQuestionIndex = 0;
        }
        if (currentQuestionIndex < 0) {
            currentQuestionIndex = questions.size() - 1;
        }
    }

    public Question getCurrentQuestion() {
        return questions.get(currentQuestionIndex);
    }
}
