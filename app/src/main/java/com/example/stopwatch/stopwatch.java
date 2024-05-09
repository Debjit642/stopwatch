package com.example.stopwatch;

import android.os.SystemClock;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class stopwatch {

    private Chronometer chronometer;
    private Button startButton;
    private Button stopButton;
    private Button resetButton;
    private TextView elapsedTimeView;

    private long startTime;
    private boolean isRunning;

    public stopwatch(Chronometer chronometer, Button startButton, Button stopButton, Button resetButton, TextView elapsedTimeView) {
        this.chronometer = chronometer;
        this.startButton = startButton;
        this.stopButton = stopButton;
        this.resetButton = resetButton;
        this.elapsedTimeView = elapsedTimeView;

        // Set up button listeners
        startButton.setOnClickListener(v -> start());
        stopButton.setOnClickListener(v -> stop());
        resetButton.setOnClickListener(v -> reset());
    }

    public void start() {
        if (!isRunning) {
            startTime = SystemClock.elapsedRealtime() - chronometer.getBase();
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            isRunning = true;
        }
    }

    public void stop() {
        if (isRunning) {
            chronometer.stop();
            isRunning = false;
            updateElapsedTime();
        }
    }

    public void reset() {
        chronometer.setBase(SystemClock.elapsedRealtime());
        elapsedTimeView.setText("00:00");
        isRunning = false;
    }

    private void updateElapsedTime() {
        long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
        int seconds = (int) (elapsedMillis / 1000);
        int minutes = seconds / 60;
        seconds %= 60;
        String formattedTime = String.format("%02d:%02d", minutes, seconds);
        elapsedTimeView.setText(formattedTime);
    }
}