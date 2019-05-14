package com.dimrix.mvpfundamentals.ex_4.screens.details.movie_fragment;

import android.text.TextUtils;

import com.dimrix.mvpfundamentals.base.BaseView;
import com.dimrix.mvpfundamentals.ex_4.enteties.Movie;

public class MovieDetailsPresenter implements MovieDetailsContract.Presenter {

    MovieDetailsContract.View mView;
    private Movie mMovie;

    @Override
    public void start() {
        setMovieViews();
    }

    private void setMovieViews() {

        mView.setCover(mMovie.getBackImageRes());
        mView.setThumbnail(mMovie.getImageRes());
        mView.setTitle(mMovie.getName());
        mView.setReleaseDate(mMovie.getReleaseDate());
        mView.setOverview(mMovie.getOverview());


    }


    @Override
    public void attachView(BaseView view) {
        mView = (MovieDetailsContract.View) view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void setMovieData(Movie movie) {
        this.mMovie = movie;
    }

    @Override
    public void onTrailerClicked() {
        if (mMovie == null) return;
        String trailerUrl = mMovie.getTrailerUrl();
        if (TextUtils.isEmpty(trailerUrl)) return;

        mView.openUrlInBrowser(trailerUrl);

    }
}
