package com.dimrix.mvpfundamentals.ex_4.screens.list.adapters;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.dimrix.mvpfundamentals.R;
import com.dimrix.mvpfundamentals.ex_4.screens.list.MoviesListContract;
import com.dimrix.mvpfundamentals.ex_4.screens.list.view_holders.MovieVH;

public class MoviesListAdapter extends RecyclerView.Adapter<MovieVH> {


    MoviesListContract.Presenter presenter;


    public MoviesListAdapter(MoviesListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public MovieVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MovieVH(presenter, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false));

    }

    @Override
    public void onBindViewHolder(@NonNull MovieVH movieVH, int i) {
        presenter.onBindItemRowViewAtPosition(movieVH, i);
    }


    @Override
    public int getItemCount() {
        return presenter.getItemsRowsCount();
    }
}
