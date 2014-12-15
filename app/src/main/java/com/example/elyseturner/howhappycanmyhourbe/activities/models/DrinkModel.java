package com.example.elyseturner.howhappycanmyhourbe.activities.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by elyseturner on 12/12/14.
 */
public class DrinkModel implements Parcelable {
    private String name;
    private double calories;

    public DrinkModel(int id, String name, String type, double calories, String imgURL) {
        this.name = name;
        this.calories = calories;
    }

    public DrinkModel() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeDouble(this.calories);
    }

    private DrinkModel(Parcel in) {
        this.name = in.readString();
        this.calories = in.readDouble();
    }

    public static final Parcelable.Creator<DrinkModel> CREATOR = new Parcelable.Creator<DrinkModel>() {
        public DrinkModel createFromParcel(Parcel source) {
            return new DrinkModel(source);
        }

        public DrinkModel[] newArray(int size) {
            return new DrinkModel[size];
        }
    };
}
