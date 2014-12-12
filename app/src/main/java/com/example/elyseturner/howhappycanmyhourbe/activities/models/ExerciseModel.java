package com.example.elyseturner.howhappycanmyhourbe.activities.models;

/**
 * Created by elyseturner on 12/12/14.
 */
public class ExerciseModel {
    private String name;
    private String type;
    private double calories;

    public ExerciseModel(String name, String type, double calories) {
        this.name = name;
        this.type = type;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}
