package com.android.geoquiz.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.geoquiz.R;
import com.android.geoquiz.model.Question;
import com.android.geoquiz.model.QuestionDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Question> questions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView question = findViewById(R.id.question);
        Button actionTrue = findViewById(R.id.actionTrue);
        Button actionFalse = findViewById(R.id.actionFalse);

        actionTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Question question1 = questions.get(0);
                if (question1.isAnswerTrue()) {
                    Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        actionFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Question question1 = questions.get(0);
                if (question1.isAnswerTrue()) {
                    Toast.makeText(MainActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        QuestionDatabase questionDatabase = new QuestionDatabase();
        questions = questionDatabase.getQuestions();

        Question question1 = questions.get(0);
        question.setText(question1.getTextResId());



    }

}
