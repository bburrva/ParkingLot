package com.theironyard.charlotte;

/**
 * Created by Ben on 12/20/16.
 */
public class Car {
    private int id;
    private int size;
    private int rate;
    private String make;
    private String model;

    public Car() {}

    public Car(int id, int size, int rate, String make, String model) {
        this.id = id;
        this.size = size;
        this.rate = rate;
        this.make = make;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    @Override
    public String toString() {
        return String.format("Lot: %d, Car make: %s, Car model: %s, Car Size: %d, Car's Money: %d)", id, make, model, size, rate);

    }
}
