package com.dimrix.mvpfundamentals.ex_4.screens.list.view_holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dimrix.mvpfundamentals.R;
import com.dimrix.mvpfundamentals.ex_4.screens.list.MoviesListContract;

public class MovieVH extends RecyclerView.ViewHolder implements MovieVHContract {

    private MoviesListContract.Presenter presenter;
    private TextView title;
    private TextView overView;
    private ImageView thumbnail;

    public MovieVH(final MoviesListContract.Presenter presenter, @NonNull View itemView) {
        super(itemView);
        this.presenter = presenter;
        title = itemView.findViewById(R.id.item_movie_tv_title);
        overView = itemView.findViewById(R.id.item_movie_tv_overview);
        thumbnail = itemView.findViewById(R.id.item_movie_iv);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onItemClicked(getAdapterPosition());
            }
        });
    }


    @Override
    public void setTitle(String title) {
        this.title.setText(title);
    }

    @Override
    public void setOverView(String overView) {
        this.overView.setText(overView);

    }

    @Override
    public void setThumbnailUrl(int res) {
        this.thumbnail.setImageResource(res);
    }


}
