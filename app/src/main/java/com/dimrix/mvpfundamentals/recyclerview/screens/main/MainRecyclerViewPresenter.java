package com.dimrix.mvpfundamentals.recyclerview.screens.main;


import com.dimrix.mvpfundamentals.base.BaseView;
import com.dimrix.mvpfundamentals.recyclerview.DataProvider;
import com.dimrix.mvpfundamentals.recyclerview.enteties.RecyclerViewData;
import com.dimrix.mvpfundamentals.recyclerview.viewholders.main.MainRecyclerViewVH;

import java.util.ArrayList;

/**
 * Created by hezidimri on 13/03/2017.
 */

public class MainRecyclerViewPresenter implements MainRecyclerViewContract.Presenter {

    private MainRecyclerViewContract.View mView;

    private ArrayList<RecyclerViewData> mDataSet;

    MainRecyclerViewPresenter() {
    }

    private MainRecyclerViewContract.View getView() {
        return mView;
    }

    @Override
    public void start() {
        mDataSet = DataProvider.getData();
        getView().createAndAttachRecyclerViewAdapterToPresenter(this);
        updateListWithData(mDataSet);
    }

    private void updateListWithData(ArrayList<RecyclerViewData> mDataSet) {

    }

    @Override
    public void attachView(BaseView view) {
        this.mView = (MainRecyclerViewContract.View) view;
    }


    @Override
    public void detachView() {
        this.mView = null;
    }

    @Override
    public void onBindItemRowViewAtPosition(MainRecyclerViewVH rowView, int position) {
        RecyclerViewData recyclerViewData = mDataSet.get(position);
        rowView.setTitle(recyclerViewData.getName());
        rowView.setOverView(recyclerViewData.getOverview());
        rowView.setImage(recyclerViewData.getImageRes());

    }

    @Override
    public int getItemsRowsCount() {
        return mDataSet.size();
    }

    @Override
    public void onItemClicked(int position) {
        getView().showToast("clicked on item number : " + position);
    }


}
