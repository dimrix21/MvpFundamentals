package com.dimrix.mvpfundamentals.counter.screens.second;

import android.support.annotation.StringRes;

import com.dimrix.mvpfundamentals.base.BasePresenter;
import com.dimrix.mvpfundamentals.base.BaseView;


class SecondActivityContract {

    interface View extends BaseView {

        void showReceivedCount(int count);

        void showToast(@StringRes int text);
    }

    interface Presenter extends BasePresenter {


    }
}
