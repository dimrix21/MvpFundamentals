package com.dimrix.mvpfundamentals.ex_4.screens.list;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dimrix.mvpfundamentals.R;
import com.dimrix.mvpfundamentals.ex_4.screens.list.adapters.MoviesListAdapter;
import com.dimrix.mvpfundamentals.ex_4.screens.main.MainActivityContract;

public class MoviesListFragment extends Fragment implements MoviesListContract.View {

    public final String TAG = "MoviesDetailsActivity";
    MoviesListContract.Presenter mPresenter;
    RecyclerView mRecyclerView;
    MainActivityContract.View mActivityListener;

    public static MoviesListFragment newInstance() {
        return new MoviesListFragment();
    }


    @Override
    public void onAttach(Context context) {
        mActivityListener = (MainActivityContract.View) getActivity();
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies_list, container, false);
        initViews(view);
        attachPresenter();
        return view;
    }


    public void initViews(View root) {
        mRecyclerView = root.findViewById(R.id.movies_rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void createAndAttachRecyclerViewAdapterToPresenter(MoviesListContract.Presenter mainRecyclerViewPresenter) {
        MoviesListAdapter adapter = new MoviesListAdapter(mainRecyclerViewPresenter);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void moveToDetails(int position) {
        mActivityListener.openDetailsActivity(position);
    }

    @Override
    public void attachPresenter() {
        mPresenter = new MoviesListPresenter();
        mPresenter.attachView(this);
        mPresenter.start();
    }
}
