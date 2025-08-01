package com.carbooking;

public class Car {
    private int id;
    private String brand;
    private String model;
    private double pricePerDay;
    private boolean booked; // true if rented

    public Car(int id, String brand, String model, double pricePerDay) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.booked = false; // initially available
    }

   
   
       

    public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getBrand() {
		return brand;
	}





	public void setBrand(String brand) {
		this.brand = brand;
	}





	public String getModel() {
		return model;
	}





	public void setModel(String model) {
		this.model = model;
	}





	public double getPricePerDay() {
		return pricePerDay;
	}





	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}





	public boolean isBooked() {
		return booked;
	}





	public void setBooked(boolean booked) {
		this.booked = booked;
	}





	@Override
    public String toString() {
        return "Car{id=" + id +
               ", brand='" + brand + '\'' +
               ", model='" + model + '\'' +
               ", pricePerDay=" + pricePerDay +
               ", available=" + (!booked) +
               '}';
    }

	public void displayInfo() {
		// TODO Auto-generated method stub
		 System.out.println("ID: " + id +
                 ", Brand: " + brand +
                 ", Model: " + model +
                 ", Price/Day: " + pricePerDay +
                 ", Available: " + (!booked));
}
		
	}

