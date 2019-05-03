package com.example.hello_android;

public class MotorCycle extends Vehicle {
    public MotorCycle(VehicleOwner owner, String registration, int odometer) {
        super(owner, registration);
        this.odometer = odometer;
    }
}
