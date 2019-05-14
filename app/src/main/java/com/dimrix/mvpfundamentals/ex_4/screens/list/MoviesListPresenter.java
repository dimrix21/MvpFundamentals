package com.dimrix.mvpfundamentals.ex_4.screens.list;

import com.dimrix.mvpfundamentals.base.BaseVH;
import com.dimrix.mvpfundamentals.base.BaseView;
import com.dimrix.mvpfundamentals.ex_4.MoviesProvider;
import com.dimrix.mvpfundamentals.ex_4.enteties.Movie;
import com.dimrix.mvpfundamentals.ex_4.screens.list.view_holders.MovieVHContract;

import java.util.ArrayList;

public class MoviesListPresenter implements MoviesListContract.Presenter {

    ArrayList<Movie> mMoviesList;
    MoviesListContract.View mView;


    @Override
    public void onBindItemRowViewAtPosition(BaseVH rowView, int position) {
        Movie data = mMoviesList.get(position);
        MovieVHContract vh = (MovieVHContract) rowView;
        vh.setTitle(data.getName());
        vh.setOverView(data.getOverview());
        vh.setThumbnailUrl(data.getImageRes());

    }

    @Override
    public int getItemsRowsCount() {
        return mMoviesList.size();
    }

    @Override
    public void onItemClicked(int position) {
        getView().moveToDetails(position);
    }

    private MoviesListContract.View getView() {
        return mView;
    }

    @Override
    public void start() {
        getMovies();
        mView.createAndAttachRecyclerViewAdapterToPresenter(this);

    }

    private void getMovies() {
        mMoviesList = MoviesProvider.loadMovies();
    }

    @Override
    public void attachView(BaseView view) {
        this.mView = (MoviesListContract.View) view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
