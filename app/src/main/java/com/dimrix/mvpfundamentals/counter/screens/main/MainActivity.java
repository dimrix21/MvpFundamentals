package com.dimrix.mvpfundamentals.counter.screens.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dimrix.mvpfundamentals.R;
import com.dimrix.mvpfundamentals.counter.screens.second.SecondActivity;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View, View.OnClickListener {

    private TextView mCounterTextView;
    private Button mCounterAddButton;
    private MainActivityContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        attachPresenter();

    }

    private void attachPresenter() {
        mPresenter = (MainActivityContract.Presenter) getLastCustomNonConfigurationInstance();
        if (mPresenter == null) {
            mPresenter = new MainActivityPresenter();
        }
        mPresenter.attachView(this);

        mPresenter.start();
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return mPresenter;
    }


    private void initViews() {
        mCounterTextView = findViewById(R.id.main_text);
        mCounterAddButton = findViewById(R.id.main_add_button);
        mCounterAddButton.setOnClickListener(this);
    }


    @Override
    public void updateCounter(int counter) {
        mCounterTextView.setText(String.valueOf(counter));

    }

    @Override
    public void navigateToSecondActivity(int counter) {
        SecondActivity.start(this, counter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_add_button:
                mPresenter.onAddButtonClicked();
                break;
        }
    }
}
