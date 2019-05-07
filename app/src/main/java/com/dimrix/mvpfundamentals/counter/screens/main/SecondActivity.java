package com.dimrix.mvpfundamentals.counter.screens.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.dimrix.mvpfundamentals.R;


public class SecondActivity extends AppCompatActivity {

    private static final String EXTRA_DATA_COUNTER = "EDC";
    private TextView mCounterTextView;

    public static void start(Context context, int counter) {
        Intent openSecondActivity = new Intent(context, SecondActivity.class);
        openSecondActivity.putExtra(EXTRA_DATA_COUNTER, counter);
        context.startActivity(openSecondActivity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mCounterTextView = findViewById(R.id.main_text);

        final int counterFromIntent = getIntent().getIntExtra(EXTRA_DATA_COUNTER, -1);
        if (counterFromIntent != -1) {
            Toast.makeText(this, "Got the counter successfully" + counterFromIntent, Toast.LENGTH_LONG).show();
            mCounterTextView.setText(String.valueOf(counterFromIntent));
        } else {
            Toast.makeText(this, "ERROR receiving number from first activity" + counterFromIntent, Toast.LENGTH_LONG).show();
            mCounterTextView.setText("Error");

        }
    }
}
