package com.example.hello_android;

public class Bus extends Vehicle {
    private int odometer;


    public Bus(String registration, int odometer) {
        super(registration);
        this.odometer = odometer;
    }
}

