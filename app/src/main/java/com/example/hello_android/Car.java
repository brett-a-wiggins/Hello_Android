package com.example.hello_android;


public class Car extends Vehicle {
    private int odometer;
    private int startOdometer;

    public Car(String registration, int odometer) {
        super(registration, odometer);
        this.odometer = odometer;
        this.startOdometer = odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer += odometer;
    }

    public int getOdometer() {
        return this.odometer;
    }

    public int getStartOdometer() {
        return this.startOdometer;
    }

}
