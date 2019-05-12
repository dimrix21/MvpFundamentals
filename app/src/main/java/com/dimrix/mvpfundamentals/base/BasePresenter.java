package com.dimrix.mvpfundamentals.base;


/**
 * Created by hezidimri on 13/03/2017.
 */

public interface BasePresenter {

    void start();

    void attachView(BaseView view);

    void detachView();

}

