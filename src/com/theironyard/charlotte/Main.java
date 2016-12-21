package com.theironyard.charlotte;

import jodd.json.*;
import spark.Spark;
import sun.plugin2.message.Serializer;

import java.util.ArrayList;

import static spark.Spark.before;

public class Main {
    private static ArrayList<ParkingLot> parkinglot = new ArrayList<>();
    private static JsonParser parser = new JsonParser();
    private static JsonSerializer serializer = new JsonSerializer();

    public static void main(String[] args) {
        parkinglot.add(new ParkingLot(0, 20, 6));
        parkinglot.add(new ParkingLot(1, 15, 5));
        parkinglot.add(new ParkingLot(2, 30, 7));

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
        });

        Spark.get("/parking-lot", ((request, response) -> {
            System.out.println("Someone is trying to park a car.");
            return serializer.serialize(parkinglot);
        }));

        Spark.post("/update", ((request, response) -> {
            Update update = parser.parse(request.body(), Update.class);

            switch(update.getId()) {
                case 0:
                    if(update.getSize() <= update.getSize() && update.getMoney() >= (update.getMoney() * update.getSize())) {
                        updateLotZero(update.getSize(), update.getSize());
                    } else {
                        System.out.println("car doesn't fit or can't pay");
                        return "";
                    }
                case 1:
                    if(update.getSize() <= update.getSize() && update.getMoney() >= (update.getMoney() * update.getSize())) {
                        updateLotOne(update.getSize(), update.getSize());
                    } else {
                        System.out.println("car doesn't fit or can't pay");
                        return "";
                    }
                case 2:
                    if(update.getSize() <= update.getSize() && update.getMoney() >= (update.getMoney() * update.getSize())) {
                        updateLotTwo(update.getSize(), update.getSize());
                    } else {
                        System.out.println("car doesn't fit or can't pay");
                        return "";
                    }
            }
            System.out.println("Lots updated");
            System.out.println(parkinglot);
            return "";
        }));
    }

    public static void updateLotZero(int id, int size) {
        for (ParkingLot parking : parkinglot) {
            if (parking.getId()== 0) {
                parking.setSize(parking.getSize() + size);
                break;
            }
        }
    }

    public static void updateLotOne(int id, int size) {
        for (ParkingLot parking : parkinglot) {
            if (parking.getId()== 1) {
                parking.setSize(parking.getSize() + size);
                break;
            }
        }
    }

    public static void updateLotTwo(int id, int size) {
        for (ParkingLot parking : parkinglot) {
            if (parking.getId()== 2) {
                parking.setSize(parking.getSize() + size);
                break;
            }
        }
    }

}