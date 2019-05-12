package com.dimrix.mvpfundamentals.recyclerview.viewholders.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dimrix.mvpfundamentals.R;
import com.dimrix.mvpfundamentals.recyclerview.screens.main.MainRecyclerViewContract;

public class MainRecyclerViewVH extends RecyclerView.ViewHolder implements RecyclerViewVHContract {

    TextView title;
    TextView overview;
    ImageView imageRes;
    private MainRecyclerViewContract.Presenter presenter;


    public MainRecyclerViewVH(MainRecyclerViewContract.Presenter mainRecyclerViewPresenter, @NonNull View itemView) {
        super(itemView);
        presenter = mainRecyclerViewPresenter;
        title = itemView.findViewById(R.id.rv_item_name);
        overview = itemView.findViewById(R.id.rv_item_overview);
        imageRes = itemView.findViewById(R.id.rv_item_image);

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
        this.overview.setText(overView);
    }

    @Override
    public void setImage(int res) {
        this.imageRes.setImageResource(res);

    }
}
