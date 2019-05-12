package com.dimrix.mvpfundamentals.recyclerview.screens.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.dimrix.mvpfundamentals.R;
import com.dimrix.mvpfundamentals.recyclerview.adapters.main.MainRecyclerViewAdapter;

public class MainRecyclerView extends AppCompatActivity implements MainRecyclerViewContract.View {

    RecyclerView mRecyclerView;
    private MainRecyclerViewContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_main);

        initViews();
        attachPresenter();

    }

    private void attachPresenter() {
        mPresenter = (MainRecyclerViewContract.Presenter) getLastCustomNonConfigurationInstance();
        if (mPresenter == null) {
            mPresenter = new MainRecyclerViewPresenter();
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
        mRecyclerView = findViewById(R.id.recyclerview_rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void createAndAttachRecyclerViewAdapterToPresenter(MainRecyclerViewContract.Presenter mainRecyclerViewPresenter) {
        MainRecyclerViewAdapter adapter = new MainRecyclerViewAdapter(mainRecyclerViewPresenter);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}
