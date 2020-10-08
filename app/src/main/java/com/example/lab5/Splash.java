package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {
    MediaPlayer tone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        tone = new MediaPlayer();
        tone = MediaPlayer.create(this, R.raw.food);
        tone.start();

        TimerTask task = new TimerTask() {
            public void run(){
                finish();
                tone.pause();
                startActivity(new Intent(Splash.this, ItemListActivity.class));
            }
        };
        Timer opening = new Timer();
        opening.schedule(task, 5000);
    }
}