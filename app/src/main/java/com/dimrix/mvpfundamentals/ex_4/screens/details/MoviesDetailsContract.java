package com.dimrix.mvpfundamentals.ex_4.screens.details;

import com.dimrix.mvpfundamentals.base.BaseListPresenter;
import com.dimrix.mvpfundamentals.base.BaseView;
import com.dimrix.mvpfundamentals.ex_4.enteties.Movie;

public class MoviesDetailsContract {

    interface View extends BaseView {

        void createAndAttachRecyclerViewAdapterToPresenter(MoviesDetailsContract.Presenter mainRecyclerViewPresenter);

    }

    public interface Presenter extends BaseListPresenter {


        Movie getItem(int position);
    }
}
