package com.dimrix.mvpfundamentals.recyclerview.adapters.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.dimrix.mvpfundamentals.R;
import com.dimrix.mvpfundamentals.recyclerview.screens.main.MainRecyclerViewContract;
import com.dimrix.mvpfundamentals.recyclerview.viewholders.main.MainRecyclerViewVH;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewVH> {

    private MainRecyclerViewContract.Presenter presenter;

    public MainRecyclerViewAdapter(MainRecyclerViewContract.Presenter mainRecyclerViewPresenter) {
        this.presenter = mainRecyclerViewPresenter;
    }

    @NonNull
    @Override
    public MainRecyclerViewVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MainRecyclerViewVH(presenter, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_main_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainRecyclerViewVH mainRecyclerViewVH, int i) {
        presenter.onBindItemRowViewAtPosition(mainRecyclerViewVH, i);
    }

    @Override
    public int getItemCount() {
        return presenter.getItemsRowsCount();
    }
}
