package com.pluralsight;

import java.time.LocalDateTime;

public class Vehicle extends Asset{
   private String makeModel;
   private int year;
   private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    @Override
    public double getValue() {
        int age = LocalDateTime.now().getYear() - year;
        double val;

        if (age <= 3) {
            val = getOriginalCost() * Math.pow(1 - 0.03, age);
        } else if (age <= 6) {
            val = getOriginalCost() * Math.pow(1 - 0.06, age);
        } else if (age <= 10) {
            val = getOriginalCost() * Math.pow(1 - 0.08, age);
        } else {
            val = 1000;
        }
        boolean reliable = makeModel.toLowerCase().contains("honda")  || makeModel.toLowerCase().contains("toyota");

        if (odometer > 100000 && !reliable) {
            val *= 0.75;
        }
        return val;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
}
