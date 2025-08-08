package com.carbooking;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        CarRentalSystem system = new CarRentalSystem();
        system.loadCarsFromFile("cars.txt");
        Scanner sc = new Scanner(System.in);
        int choice;
      
        // preload sample cars
//        system.addCar(new Car(1, "Honda", "City", 1500));
//        system.addCar(new Car(2, "Hyundai", "i20", 1200));

        do {
            System.out.println("\n--- Car Rental Menu ---");
            System.out.println("1. Add Car");
            System.out.println("2. Show Available Cars");
            System.out.println("3. Rent a Car");
            System.out.println("4. Return Car");
            System.out.println("5. Show All Cars");
            System.out.println("6. Show Active rentals");
            System.out.println("7. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter Car ID: ");
                    int id = sc.nextInt(); 
                    sc.nextLine();
                    System.out.print("Enter Brand: ");
                    String brand = sc.nextLine();
                    System.out.print("Enter Model: ");
                    String model = sc.nextLine();
                    System.out.print("Enter Price/Day: ");
                    double price = sc.nextDouble(); sc.nextLine();
                    system.addCar(new Car(id, brand, model, price));
                 
                    break;
                case 2:
                    system.showAvailableCars();
                    break;
                case 3:
                	 System.out.print("Enter your name: ");
                     String name = sc.nextLine(); 
                     System.out.print("Enter CarId: ");
                     int carId = sc.nextInt();
                   
                     System.out.print("Enter rental days: ");
                     int rentalDays = sc.nextInt();
                    
                     Customer customer=new Customer(name, carId, rentalDays);
                     system.addCustomer(customer);
                     Car rented=system.bookCar(carId);
                     double amount=rented.getPricePerDay() * rentalDays;
                    
                     System.out.println("Total amount for " + rentalDays + " day(s): " + amount );
                   
                  
                    break;
                case 4:
                	System.out.print("Enter CarId: ");
                	 int carId1 = sc.nextInt();
                	 sc.nextLine();
                	system.returnCar(carId1);
                	
                    break;
                case 5:
                    system.showAllCars();
                    break;
                case 6:
                	system.showActiveRentals();
                    break;
                    
                case 7:
                	system.writeToFile("cars.txt");
                    System.out.println("Exiting system.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 7);

        sc.close();
    }
}
