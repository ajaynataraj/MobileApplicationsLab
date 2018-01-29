package com.example.ajn.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button =findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,MainActivity.class));
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Pause", "on Second Activity's Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Resume","on Second Activity's Resume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Stop","on Second Activity's Stop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Start","on Second Activity's Start");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Destroy","on Second Activity's Destroy");
    }
}
