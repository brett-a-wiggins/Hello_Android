package com.example.hello_android;

public class MotorCycle extends Vehicle {
    private int odometer;

    public MotorCycle(String registration, int odometer) {
        super(registration);
        this.odometer = odometer;
    }
}
