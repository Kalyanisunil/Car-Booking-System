package com.carbooking;
import java.io.IOException; 
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;  
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
  
    public void writeToFile(String filename)
    {
    	try(BufferedWriter writer =new BufferedWriter(new FileWriter(filename))) {
    	     
    	     for(Car c: cars)
    	     {
    	    	 writer.write(c.toCSV());
    	    	 writer.newLine();
    	     }
    	     
    	     System.out.println("Saved " + cars.size() + " cars to " + filename);
    	    } catch (IOException e) {
    	      System.out.println("An error occurred."+ e.getMessage());
    	      e.printStackTrace();
    	    }
    }
  
    public void loadCarsFromFile(String filename) throws FileNotFoundException, IOException
    {
    	File file=new File(filename);
    	if(!file.exists())
    	{
    		 System.out.println("No existing data to load.");
    	        return;
    	}
    	try(BufferedReader reader=new BufferedReader(new FileReader(file)))
    	{
    		String line;
    		while((line=reader.readLine())!=null)
    		{
    			String[] parts=line.split(",");
    			if(parts.length!=5) continue;
    			int id=Integer.parseInt(parts[0]);
    			String brand=parts[1];
    			String model=parts[2];
    			double pricePerDay = Double.parseDouble(parts[3]);
                boolean booked = Boolean.parseBoolean(parts[4]);
                Car car=new Car(id,brand,model,pricePerDay);
                car.setBooked(booked);
                addCar(car);
    		}
    	}
    	catch (IOException e) {
            System.out.println("Error loading cars: " + e.getMessage());
        }
    }
   



	
}