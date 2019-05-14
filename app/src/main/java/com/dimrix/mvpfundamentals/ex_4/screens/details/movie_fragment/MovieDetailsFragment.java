package com.dimrix.mvpfundamentals.ex_4.screens.details.movie_fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dimrix.mvpfundamentals.R;
import com.dimrix.mvpfundamentals.ex_4.enteties.Movie;


public class MovieDetailsFragment extends Fragment implements View.OnClickListener, MovieDetailsContract.View {

    private static final String TAG = "MovieDetailsFragment";
    private static final String ARG_MOVIE = "MovieModel-data";
    private ImageView ivImage;
    private ImageView ivBackImage;
    private TextView tvTitle;
    private TextView tvReleaseDate;
    private TextView tvOverview;
    private MovieDetailsContract.Presenter mPresenter;

    public MovieDetailsFragment() {
    }

    public static MovieDetailsFragment newInstance(Movie movieModel) {
        MovieDetailsFragment fragment = new MovieDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_MOVIE, movieModel);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        initViews(view);


        attachPresenter();

        if (getArguments() != null) {
            Movie movie = getArguments().getParcelable(ARG_MOVIE);
            mPresenter.setMovieData(movie);
            mPresenter.start();

        }

        return view;
    }

    private void initViews(View view) {
        ivImage = view.findViewById(R.id.details_iv_image);
        ivBackImage = view.findViewById(R.id.details_iv_back);
        tvTitle = view.findViewById(R.id.details_tv_title);
        tvReleaseDate = view.findViewById(R.id.details_tv_released_date);
        tvOverview = view.findViewById(R.id.details_tv_overview_text);

        Button btnTrailer = view.findViewById(R.id.details_btn_trailer);
        btnTrailer.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        mPresenter.onTrailerClicked();

    }

    @Override
    public void openUrlInBrowser(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

    @Override
    public void attachPresenter() {
        mPresenter = new MovieDetailsPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void setCover(int res) {
        ivBackImage.setImageResource(res);
    }

    @Override
    public void setThumbnail(int res) {
        ivImage.setImageResource(res);
    }

    @Override
    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    @Override
    public void setReleaseDate(String releaseDate) {
        tvReleaseDate.setText(releaseDate);
    }

    @Override
    public void setOverview(String overview) {
        tvOverview.setText(overview);
    }
}
