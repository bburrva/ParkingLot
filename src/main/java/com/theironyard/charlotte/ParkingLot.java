package com.theironyard.charlotte;

import java.util.ArrayList;

/**
 * Created by Ben on 12/20/16.
 */
public class ParkingLot {
    private int id;
    private int capacity;
    private int cost;
    private ArrayList<Car> cars;

    public ParkingLot () {}

    public ParkingLot(int id, int capacity, int cost, ArrayList<Car> cars) {
        this.id = id;
        this.capacity = capacity;
        this.cost = cost;
        this.cars = cars;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
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

    @Override
    public String toString() {
        return "ParkingLot{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", cost=" + cost +
                ", cars=" + cars +
                '}';
    }
}
