package com.dimrix.mvpfundamentals.recyclerview.enteties;

public class RecyclerViewData {

    String name;
    int imageRes;
    String overview;

    public RecyclerViewData(String name, int imageRes, String overview) {
        this.name = name;
        this.imageRes = imageRes;
        this.overview = overview;
    }

    public String getName() {
        return name;
    }

    public int getImageRes() {
        return imageRes;
    }

    public String getOverview() {
        return overview;
    }
}
