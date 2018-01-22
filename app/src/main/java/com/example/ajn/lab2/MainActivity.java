package com.example.ajn.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);
        Button button =findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Pause", "on First Activity's Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Resume","on First Activity's Resume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Stop","on First Activity's Stop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Start","on First Activity's Start");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Destroy","on First Activity's Destroy");
    }
}
