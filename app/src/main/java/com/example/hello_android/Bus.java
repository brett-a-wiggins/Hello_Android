package com.example.hello_android;

public class Bus extends Vehicle {


    public Bus(VehicleOwner owner, String registration, int odometer) {
        super(owner, registration);
        this.odometer = odometer;
    }
}

