package com.dimrix.mvpfundamentals.ex_4.screens.details;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.dimrix.mvpfundamentals.R;
import com.dimrix.mvpfundamentals.ex_4.screens.details.movie_fragment.MovieDetailsFragment;

public class MoviesDetailsActivity extends AppCompatActivity implements MoviesDetailsContract.View {

    public static final String EXTRA_ITEM_POSITION = "init-position-data";
    private static final String TAG = "MoviesDetailsActivity";

    MoviesDetailsContract.Presenter mPresenter;
    ViewPager mViewPager;
    int mStartPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_movies_details);

        mStartPosition = getIntent().getIntExtra(EXTRA_ITEM_POSITION, 0);
        Log.d(TAG, "position selected : " + mStartPosition);
        initViews();
        attachPresenter();

    }


    public void initViews() {
        mViewPager = findViewById(R.id.movies_detail_vp);
    }

    @Override
    public void createAndAttachRecyclerViewAdapterToPresenter(MoviesDetailsContract.Presenter mainRecyclerViewPresenter) {
        MoviesDetailsAdapter adapter = new MoviesDetailsAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(mStartPosition, false);

    }


    @Override
    public void attachPresenter() {
        mPresenter = new MoviesDetailsPresenter();
        mPresenter.attachView(this);
        mPresenter.start();
    }

    public class MoviesDetailsAdapter extends FragmentPagerAdapter {

        public MoviesDetailsAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return MovieDetailsFragment.newInstance(mPresenter.getItem(position));
        }

        @Override
        public int getCount() {
            return mPresenter.getItemsRowsCount();
        }
    }
}
