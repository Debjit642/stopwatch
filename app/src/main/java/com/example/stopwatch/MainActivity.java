package com.example.stopwatch;


import android.os.Bundle;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stopwatch.R;
import com.example.stopwatch.stopwatch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        Chronometer chronometer = findViewById(R.id.chronometer);
        Button startButton = findViewById(R.id.start_button);
        Button stopButton = findViewById(R.id.stop_button);
        Button resetButton = findViewById(R.id.reset_button);
        TextView elapsedTimeView = findViewById(R.id.elapsed_time_view);

        // Create a Stopwatch object
        stopwatch stopwatch = new stopwatch(chronometer, startButton, stopButton, resetButton, elapsedTimeView);
    }
}