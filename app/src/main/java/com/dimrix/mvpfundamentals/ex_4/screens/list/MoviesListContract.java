package com.dimrix.mvpfundamentals.ex_4.screens.list;

import com.dimrix.mvpfundamentals.base.BaseListPresenter;
import com.dimrix.mvpfundamentals.base.BaseView;

public class MoviesListContract {

    interface View extends BaseView {

        void createAndAttachRecyclerViewAdapterToPresenter(MoviesListContract.Presenter mainRecyclerViewPresenter);

        void moveToDetails(int position);

    }

    public interface Presenter extends BaseListPresenter {


    }
}
