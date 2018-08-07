package com.example.test_async;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.test_async.async_task.TestAsyncTaskActivity;
import com.example.test_async.intent_service.TestIntentServiceActivity;
import com.example.test_async.java_thread.TestJavaThreadActivity;
import com.example.test_async.rx.TestRxActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button testJavaThread = findViewById(R.id.testJavaThread);
        testJavaThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TestJavaThreadActivity.class));
            }
        });
        Button testAsyncTask = findViewById(R.id.testAsyncTask);
        testAsyncTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TestAsyncTaskActivity.class));
            }
        });
        Button testIntentService = findViewById(R.id.testIntentService);
        testIntentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TestIntentServiceActivity.class));
            }
        });
        Button testRx = findViewById(R.id.testRx);
        testRx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TestRxActivity.class));
            }
        });

    }

}
