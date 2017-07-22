package com.example.ryotaro.training;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // クリック時の処理
                EditText edt = (EditText)findViewById(R.id.editText2);
                String str = edt.getText().toString();

                new CountDownTimer(10 * 1000, 1 * 1000) {
                    TextView textView = (TextView)findViewById(R.id.textView);
                    public void onTick(long millisUntilFinished) {
                        textView.setText(Long.toString(millisUntilFinished /1000));
                    }

                    public void onFinish() {
                        textView.setText("done!");
                    }
                }.start();
            }
        });
    }
}