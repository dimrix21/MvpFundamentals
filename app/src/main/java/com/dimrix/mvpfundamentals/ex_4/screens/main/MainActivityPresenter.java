package com.dimrix.mvpfundamentals.ex_4.screens.main;

import com.dimrix.mvpfundamentals.base.BaseView;

public class MainActivityPresenter implements MainActivityContract.Presenter {


    MainActivityContract.View mView;


    @Override
    public void start() {
        getView().showMoviesListFragment();
    }

    @Override
    public void attachView(BaseView view) {

        this.mView = (MainActivityContract.View) view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }

    public MainActivityContract.View getView() {
        return mView;
    }
}
