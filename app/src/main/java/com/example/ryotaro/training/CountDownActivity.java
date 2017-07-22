package com.example.ryotaro.training;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CountDownActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);
        int time = getIntent().getIntExtra("number", 0);
        new CountDownTimer(time * 1000, 100) {
            TextView textView = (TextView)findViewById(R.id.textView2);
            public void onTick(long millisUntilFinished) {
                textView.setText(Long.toString(Math.round(millisUntilFinished*0.001)));
            }

            public void onFinish() {
                ToneGenerator toneGenerator
                        = new ToneGenerator(AudioManager.STREAM_SYSTEM, ToneGenerator.MAX_VOLUME);
                toneGenerator.startTone(ToneGenerator.TONE_PROP_BEEP);
                textView.setText("done!");
            }
        }.start();


    }
}

