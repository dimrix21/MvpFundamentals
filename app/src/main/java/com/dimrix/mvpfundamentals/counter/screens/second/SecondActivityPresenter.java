package com.dimrix.mvpfundamentals.counter.screens.second;

import com.dimrix.mvpfundamentals.R;
import com.dimrix.mvpfundamentals.base.BaseView;

public class SecondActivityPresenter implements SecondActivityContract.Presenter {

    private final int mReceivedCounter;
    private SecondActivityContract.View mView;

    public SecondActivityPresenter(int receivedCounter) {
        this.mReceivedCounter = receivedCounter;
    }


    @Override
    public void start() {

        if (mReceivedCounter != -1) {
            getView().showReceivedCount(mReceivedCounter);
            getView().showToast(R.string.received_successfully);
        } else {
            getView().showReceivedCount(0);
            getView().showToast(R.string.error);
        }


    }

    @Override
    public void attachView(BaseView view) {
        this.mView = (SecondActivityContract.View) view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    private SecondActivityContract.View getView() {
        return mView;
    }


}
