package com.theironyard.charlotte;

/**
 * Created by Ben on 12/20/16.
 */
public class ParkingLot {
    private int id;
    private int capacity;
    private int cost;

    public ParkingLot(int id, int capacity, int cost) {
        this.id = id;
        this.capacity = capacity;
        this.cost = cost;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

}
