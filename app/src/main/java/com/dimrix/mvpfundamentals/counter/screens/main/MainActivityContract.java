package com.dimrix.mvpfundamentals.counter.screens.main;


import com.dimrix.mvpfundamentals.base.BasePresenter;
import com.dimrix.mvpfundamentals.base.BaseView;

/**
 * Created by hezidimri on 13/03/2017.
 */

interface MainActivityContract {

    interface View extends BaseView {

        void updateCounter(int counter);

        void navigateToSecondActivity(int mCounter);
    }

    interface Presenter extends BasePresenter {

        void onAddButtonClicked();

    }
}
