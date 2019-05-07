package com.example.hello_android;

public class Car extends Vehicle {
    private int odometer;

    public Car(String registration, int odometer) {
        super(registration);
        this.odometer = odometer;
    }

}
