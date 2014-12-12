package com.example.elyseturner.howhappycanmyhourbe.activities.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by elyseturner on 12/12/14.
 */
public class MinutesModel implements Parcelable {
    private double minutes;

    public MinutesModel(double minutes) {
        this.minutes = minutes;
    }

    public double getMinutes() {
        return minutes;
    }

    public void setMinutes(double minutes) {
        this.minutes = minutes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.minutes);
    }

    private MinutesModel(Parcel in) {
        this.minutes = in.readDouble();
    }

    public static final Parcelable.Creator<MinutesModel> CREATOR = new Parcelable.Creator<MinutesModel>() {
        public MinutesModel createFromParcel(Parcel source) {
            return new MinutesModel(source);
        }

        public MinutesModel[] newArray(int size) {
            return new MinutesModel[size];
        }
    };
}
