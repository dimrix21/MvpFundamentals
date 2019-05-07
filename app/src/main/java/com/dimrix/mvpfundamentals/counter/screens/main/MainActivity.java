package com.dimrix.mvpfundamentals.counter.screens.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.dimrix.mvpfundamentals.R;

public class MainActivity extends AppCompatActivity {


    private static final String STATE_COUNTER = "SC";
    private int mCounter = 0;
    private TextView mCounterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCounterTextView = findViewById(R.id.main_text);
    }

    public void increaseCount(View view) {
        mCounter++;
        mCounterTextView.setText(String.valueOf(mCounter));

        if (mCounter > 10) {
            navigateToSecondActivity();
            return;
        }
    }

    private void navigateToSecondActivity() {
        SecondActivity.start(this, mCounter);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_COUNTER, mCounter);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mCounter = savedInstanceState.getInt(STATE_COUNTER);
            updateCounterValue();


        }
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void updateCounterValue() {
        mCounterTextView.setText(String.valueOf(mCounter));
    }
}
