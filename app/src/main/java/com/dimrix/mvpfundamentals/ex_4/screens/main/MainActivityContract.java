package com.dimrix.mvpfundamentals.ex_4.screens.main;

import com.dimrix.mvpfundamentals.base.BasePresenter;
import com.dimrix.mvpfundamentals.base.BaseView;

public class MainActivityContract {

    public interface View extends BaseView {

        void showMoviesListFragment();

        void openDetailsActivity(int position);


    }

    interface Presenter extends BasePresenter {
    }
}
