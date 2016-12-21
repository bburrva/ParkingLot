package com.theironyard.charlotte;

/**
 * Created by Ben on 12/20/16.
 */
public class ParkingLot {
    private int id;
    private int size;
    private int money;

    public ParkingLot(int id, int size, int money) {
        this.id = id;
        this.size = size;
        this.money = money;
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

}
