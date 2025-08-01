package com.carbooking;

public class Customer {
    private String name;
    private int carId;
    private int rentalDays;

    public Customer(String name, int carId, int rentalDays) {
        this.name = name;
        this.carId = carId;
        this.rentalDays = rentalDays;
    }

    public String getName() { return name; }
    public int getCarId() { return carId; }
    public int getRentalDays() { return rentalDays; }

    @Override
    public String toString() {
        return "Customer{name='" + name + '\'' +
               ", carId=" + carId +
               ", rentalDays=" + rentalDays +
               '}';
    }
}
