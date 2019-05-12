package com.dimrix.mvpfundamentals.counter.screens.main;


import com.dimrix.mvpfundamentals.base.BaseView;

/**
 * Created by hezidimri on 13/03/2017.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private MainActivityContract.View mView;
    private int mCounter = 0;

    MainActivityPresenter() {
    }

    private MainActivityContract.View getView() {
        return mView;
    }

    @Override
    public void start() {
    }

    @Override
    public void attachView(BaseView view) {
        this.mView = (MainActivityContract.View) view;
        updateView();
    }


    @Override
    public void onAddButtonClicked() {
        mCounter++;
        updateView();

        if (mCounter > 10) {
            getView().navigateToSecondActivity(mCounter);
        }
    }


    @Override
    public void detachView() {
        this.mView = null;
    }

    private void updateView() {
        if (getView() != null) {
            getView().updateCounter(mCounter);
        }
    }
}
