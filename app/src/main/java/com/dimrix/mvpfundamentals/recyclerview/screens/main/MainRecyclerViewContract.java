package com.dimrix.mvpfundamentals.recyclerview.screens.main;


import com.dimrix.mvpfundamentals.base.BasePresenter;
import com.dimrix.mvpfundamentals.base.BaseView;
import com.dimrix.mvpfundamentals.recyclerview.viewholders.main.MainRecyclerViewVH;

/**
 * Created by hezidimri on 13/03/2017.
 */

public interface MainRecyclerViewContract {

    interface View extends BaseView {


        void createAndAttachRecyclerViewAdapterToPresenter(MainRecyclerViewContract.Presenter mainRecyclerViewPresenter);

        void showToast(String text);
    }

    interface Presenter extends BasePresenter {

        void onBindItemRowViewAtPosition(MainRecyclerViewVH rowView, int position);

        int getItemsRowsCount();

        void onItemClicked(int position);

    }
}
