package com.carbooking;

import java.util.ArrayList;
import java.util.List;

public class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;

    public CarRentalSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
    }

    public void addCar(Car car) {
        // TODO: prevent duplicate IDs if you want later
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void showAvailableCars() {
        System.out.println("=== Available Cars ===");
        boolean found = false;
        for (Car c : cars) {
            if (!c.isBooked()) {
                c.displayInfo();
                System.out.println("-------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No cars available.");
        }
    }

    public void showAllCars() {
        System.out.println("=== All Cars ===");
        for (Car c : cars) {
            c.displayInfo();
            System.out.println("-------------------");
        }
    }

    public Car bookCar(int id) {
        for (Car c : cars) {
            if (c.getId() == id) {
                if (c.isBooked()) {
                    System.out.println("Car is already booked.");
                    return null;
                } else {
                    c.setBooked(true);
                    System.out.println("Car booked: " + c.getBrand() + " " + c.getModel());
                  
                    return c;
                }
            }
        }
        System.out.println("Car with ID " + id + " not found.");
        return null;
    }

    public boolean returnCar(int id) {
        for (Car c : cars) {
            if (c.getId() == id) {
                if (!c.isBooked()) {
                    System.out.println("Car was not booked.");
                    return false;
                } else {
                    c.setBooked(false);
                    System.out.println("Car returned: " + c.getBrand() + " " + c.getModel());
                    return true;
                }
            }
        }
        System.out.println("Car with ID " + id + " not found.");
        return false;
    }

  
   



	
}