package com.example.hello_android;

public class Car extends Vehicle {

    public Car(VehicleOwner owner, String registration, int odometer) {
        super(owner, registration);
        this.odometer = odometer;
    }
}
