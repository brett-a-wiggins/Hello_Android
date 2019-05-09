package com.example.hello_android;

public class VehicleDbSchema {
    public static final class VehicleTable{
        public static final String TABLE_NAME = "VEHICLE";

        public static final class Cols{
            public static final String REGISTRATION = "registration";
            public static final String ODOMETER = "odometer";
            public static final String TRANS_LIST = "fuel_trans_list";
            public static final String SERVICE_TRANS_LIST = "service_trans_list";
        }
    }
}
