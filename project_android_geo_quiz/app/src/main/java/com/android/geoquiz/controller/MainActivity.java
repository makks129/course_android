package com.android.geoquiz.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.geoquiz.R;
import com.android.geoquiz.model.Question;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity_TAG";
    private static final int REQUEST_CODE = 0;

    private QuestionDatabaseManager questionDatabaseManager;

    private TextView question;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);

        question = findViewById(R.id.question);
        Button actionTrue = findViewById(R.id.actionTrue);
        Button actionFalse = findViewById(R.id.actionFalse);
        Button actionPrevious = findViewById(R.id.actionPrevious);
        Button actionNext = findViewById(R.id.actionNext);
        Button actionCheat = findViewById(R.id.actionCheat);

        actionTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Question q = questionDatabaseManager.getQuestionDatabase().getCurrentQuestion();
                if (q.isAnswerTrue()) {
                    Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        actionFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Question q = questionDatabaseManager.getQuestionDatabase().getCurrentQuestion();
                if (q.isAnswerTrue()) {
                    Toast.makeText(MainActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        actionPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionDatabaseManager.getQuestionDatabase().changeQuestionIndexBy(-1);
                setQuestionText();
            }
        });

        actionNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionDatabaseManager.getQuestionDatabase().changeQuestionIndexBy(1);
                setQuestionText();
            }
        });

        if (actionCheat != null) {
            actionCheat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CheatActivity.startActivityForResult(MainActivity.this,
                            questionDatabaseManager.getQuestionDatabase().getCurrentQuestion().isAnswerTrue(), REQUEST_CODE);
                }
            });
        }

        questionDatabaseManager = new QuestionDatabaseManager();
        questionDatabaseManager.onCreate(savedInstanceState);
        setQuestionText();
    }

    public void setQuestionText() {
        Question q = questionDatabaseManager.getQuestionDatabase().getCurrentQuestion();
        question.setText(q.getTextResId());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            boolean cheater = CheatActivity.isCheater(data);
            if (cheater) {
                Toast.makeText(this, "Cheating is bad!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
        questionDatabaseManager.onSaveInstanceState(outState);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

}
