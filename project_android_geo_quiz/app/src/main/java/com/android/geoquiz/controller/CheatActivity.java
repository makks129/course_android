package com.android.geoquiz.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.geoquiz.R;

public class CheatActivity extends AppCompatActivity {

    private static final String EXTRA_ANSWER_TRUE = "EXTRA_ANSWER_TRUE";
    private static final String EXTRA_CHEATER = "EXTRA_CHEATER";

    private TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        answer = findViewById(R.id.answer);
        Button actionCheat = findViewById(R.id.actionCheat);

        answer.setVisibility(View.INVISIBLE);

        actionCheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setVisibility(View.VISIBLE);
                Intent intent = new Intent();
                intent.putExtra(EXTRA_CHEATER, true);
                setResult(RESULT_OK, intent);
            }
        });

        Intent intent = getIntent();
        boolean answerTrue = intent.getBooleanExtra(EXTRA_ANSWER_TRUE, false);
        answer.setText(String.valueOf(answerTrue));

    }


    public static void startActivityForResult(Activity activity, boolean answerTrue, int requestCode) {
        Intent intent = new Intent(activity, CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_TRUE, answerTrue);
        activity.startActivityForResult(intent, requestCode);
    }

    public static boolean isCheater(Intent data) {
        return data.getBooleanExtra(EXTRA_CHEATER, false);
    }


}
