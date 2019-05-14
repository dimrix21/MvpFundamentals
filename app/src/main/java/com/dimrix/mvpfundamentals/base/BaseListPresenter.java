package com.dimrix.mvpfundamentals.base;

public interface BaseListPresenter extends BasePresenter {

    void onBindItemRowViewAtPosition(BaseVH rowView, int position);

    int getItemsRowsCount();

    void onItemClicked(int position);


}
