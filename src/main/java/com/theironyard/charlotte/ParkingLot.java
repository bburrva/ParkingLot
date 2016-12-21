package com.theironyard.charlotte;

/**
 * Created by Ben on 12/20/16.
 */
public class ParkingLot {
    private int id;
    private int capacity;
    private int rate;

    public ParkingLot(int id, int capacity, int rate) {
        this.id = id;
        this.capacity = capacity;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {return capacity;}

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

}
