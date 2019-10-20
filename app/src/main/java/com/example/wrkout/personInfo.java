package com.example.wrkout;

import java.util.ArrayList;

public class personInfo {
    private String name;
    private int age;
    private double weight;
    private double height;
    private int reps;
    private int minutes;
    private double healthScale;
    private double[] bodyMap;
    private ArrayList<excerName> excercises = new ArrayList<excerName>();

    public personInfo(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.reps = 0;
        this.minutes = 0;
        this.healthScale = 0;
        this.bodyMap = new double[8];
    }

    public void updateReps(int increment) {
        int temp = getReps();
        temp +=  increment;
        this.reps = temp;
    }

    public void updateMins(int increment) {
        int temp = getMins();
        temp+= increment;
        this.minutes = temp;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWeight() {
        return this.weight;
    }

    public int getReps(){
        return this.reps;
    }

    public int getMins() {
        return this.minutes;
    }

    public double getScale() {
        return this.healthScale;
    }

    public void addExcercise(String name,int intensity,int excerciseType,int reps) {
        excerName temp = new excerName(name,intensity,excerciseType,reps);
        excercises.add(temp);
        bodyMap[excerciseType] = (intensity/10) * excercises.size();
    }

}

