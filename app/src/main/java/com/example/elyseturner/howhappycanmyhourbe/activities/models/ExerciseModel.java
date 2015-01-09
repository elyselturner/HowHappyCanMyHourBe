package com.example.elyseturner.howhappycanmyhourbe.activities.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by elyseturner on 12/12/14.
 */
public class ExerciseModel implements Parcelable {
    private String name;
    private double calories;

    public ExerciseModel() {
        this.calories = calories;
        this.name = name;
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

    public void setCalories(int calories) {
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

    private ExerciseModel(Parcel in) {
        this.name = in.readString();
        this.calories = in.readInt();
    }

    public static final Parcelable.Creator<ExerciseModel> CREATOR = new Parcelable.Creator<ExerciseModel>() {
        public ExerciseModel createFromParcel(Parcel source) {
            return new ExerciseModel(source);
        }

        public ExerciseModel[] newArray(int size) {
            return new ExerciseModel[size];
        }
    };
}
