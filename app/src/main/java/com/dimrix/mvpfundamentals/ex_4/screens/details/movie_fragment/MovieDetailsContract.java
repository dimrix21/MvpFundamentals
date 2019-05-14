package com.dimrix.mvpfundamentals.ex_4.screens.details.movie_fragment;

import com.dimrix.mvpfundamentals.base.BasePresenter;
import com.dimrix.mvpfundamentals.base.BaseView;
import com.dimrix.mvpfundamentals.ex_4.enteties.Movie;

public class MovieDetailsContract {

    interface View extends BaseView {

        void setCover(int res);

        void setThumbnail(int res);

        void setTitle(String title);

        void setReleaseDate(String releaseDate);

        void setOverview(String overview);

        void openUrlInBrowser(String url);
    }

    interface Presenter extends BasePresenter {

        void setMovieData(Movie movie);

        void onTrailerClicked();
    }
}
