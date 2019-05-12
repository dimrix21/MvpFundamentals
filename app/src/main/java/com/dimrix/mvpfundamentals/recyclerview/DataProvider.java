package com.dimrix.mvpfundamentals.recyclerview;

import com.dimrix.mvpfundamentals.R;
import com.dimrix.mvpfundamentals.recyclerview.enteties.RecyclerViewData;

import java.util.ArrayList;

public class DataProvider {

    public static ArrayList<RecyclerViewData> getData() {
        ArrayList<RecyclerViewData> recyclerViewData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            recyclerViewData.add(new RecyclerViewData("item number  " + i, R.drawable.terminator, "more text"));
        }
        return recyclerViewData;
    }
}
