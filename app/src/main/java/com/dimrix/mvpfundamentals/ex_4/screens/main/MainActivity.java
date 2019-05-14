package com.dimrix.mvpfundamentals.ex_4.screens.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dimrix.mvpfundamentals.R;
import com.dimrix.mvpfundamentals.ex_4.screens.details.MoviesDetailsActivity;
import com.dimrix.mvpfundamentals.ex_4.screens.list.MoviesListFragment;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    MainActivityContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        attachPresenter();
    }

    @Override
    public void showMoviesListFragment() {
        MoviesListFragment moviesListFragment = MoviesListFragment.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.movies_fragments_container, moviesListFragment, moviesListFragment.TAG).addToBackStack(null).commit();
    }

    @Override
    public void openDetailsActivity(int position) {
        Intent intent = new Intent(this, MoviesDetailsActivity.class);
        intent.putExtra(MoviesDetailsActivity.EXTRA_ITEM_POSITION, position);
        startActivity(intent);
    }


    // Lifecycle , we keep the presenter alive in case of activity destroyed .

    @Override
    public void attachPresenter() {
        mPresenter = (MainActivityContract.Presenter) getLastCustomNonConfigurationInstance();
        if (mPresenter == null) {
            mPresenter = new MainActivityPresenter();
            mPresenter.attachView(this);
            mPresenter.start();
        } else {
            mPresenter.attachView(this);
        }

    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }
}
