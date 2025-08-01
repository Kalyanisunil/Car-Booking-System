package com.carbooking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarRentalSystem system = new CarRentalSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        // preload sample cars
        system.addCar(new Car(1, "Honda", "City", 1500));
        system.addCar(new Car(2, "Hyundai", "i20", 1200));

        do {
            System.out.println("\n--- Car Rental Menu ---");
            System.out.println("1. Add Car");
            System.out.println("2. Show Available Cars");
            System.out.println("3. Rent a Car");
            System.out.println("4. Return Car");
            System.out.println("5. Show All Cars");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Car ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Brand: ");
                    String brand = sc.nextLine();
                    System.out.print("Enter Model: ");
                    String model = sc.nextLine();
                    System.out.print("Enter Price/Day: ");
                    double price = sc.nextDouble(); sc.nextLine();
                    system.addCar(new Car(id, brand, model, price));
                    System.out.println("Car added.");
                    break;
                case 2:
                    system.showAvailableCars();
                    break;
                case 3:
                   
                    break;
                case 4:
                   
                    break;
                case 5:
                    system.showAllCars();
                    break;
                case 6:
                    System.out.println("Exiting system.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}
