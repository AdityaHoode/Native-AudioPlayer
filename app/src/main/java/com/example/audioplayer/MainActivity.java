package com.example.audioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button play, pause, stop, forward, rewind;
    MediaPlayer mp;
    int currentPos = 0;
    int stopTime = 0;
    int fStep = 5000;
    int rStep = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        stop = findViewById(R.id.stop);
        forward = findViewById(R.id.forward);
        rewind = findViewById(R.id.rewind);

        mp = MediaPlayer.create(this,R.raw.countingstars);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.seekTo(0);
                mp.pause();
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = mp.getCurrentPosition();
                if((currentPos+fStep) <= (stopTime = mp.getDuration())){
                    mp.seekTo(currentPos+fStep);
                }
            }
        });

        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = mp.getCurrentPosition();
                if((currentPos-rStep) >= 0){
                    mp.seekTo(currentPos-rStep);
                }
            }
        });
    }
}