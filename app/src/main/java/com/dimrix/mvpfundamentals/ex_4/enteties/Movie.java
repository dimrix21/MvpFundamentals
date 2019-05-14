package com.dimrix.mvpfundamentals.ex_4.enteties;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;


public class Movie implements Parcelable {

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
    private String name;
    @DrawableRes
    private int imageRes;
    @DrawableRes
    private int backImageRes;
    private String overview;
    private String releaseDate;
    private String trailerUrl;

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.name = in.readString();
        this.imageRes = in.readInt();
        this.backImageRes = in.readInt();
        this.overview = in.readString();
        this.releaseDate = in.readString();
        this.trailerUrl = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DrawableRes
    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(@DrawableRes int imageRes) {
        this.imageRes = imageRes;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @DrawableRes
    public int getBackImageRes() {
        return backImageRes;
    }

    public void setBackImageRes(@DrawableRes int backImageRes) {
        this.backImageRes = backImageRes;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.imageRes);
        dest.writeInt(this.backImageRes);
        dest.writeString(this.overview);
        dest.writeString(this.releaseDate);
        dest.writeString(this.trailerUrl);
    }
}
