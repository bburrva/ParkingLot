package com.theironyard.charlotte;

import jodd.json.*;
import spark.Spark;

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

        String port = System.getenv("PORT");
        if (port != null) {
            Spark.port(Integer.valueOf(port));
        }

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
        });

        Spark.get("/parking-lot", ((request, response) -> {
            System.out.println("Someone is trying to park a car.");
            return serializer.serialize(parkinglot);
        }));

        Spark.post("/update", ((request, response) -> {
            Update update = parser.parse(request.body(), Update.class);

            if (update.getSize() <= returnLot(update.getId()).getCapacity() && update.getRate() >= (returnLot(update.getId()).getRate() * update.getSize())) {
                updateLot(returnLot(update.getId()).getId(), returnLot(update.getId()).getCapacity());
            } else if((update.getSize() > returnLot(update.getId()).getCapacity())){
                System.out.println("car doesn't fit");
                return "";
            } else if(update.getRate() < (returnLot(update.getId()).getRate() * update.getSize())) {
                System.out.println("Car doesn't have enough money");
                return "";
            }

            System.out.println("Lots updated");
            System.out.println(parkinglot);
            return "";
        }));
    }

    public static void updateLot(int id, int size) {
        for (ParkingLot parking : parkinglot) {
            if (parking.getId() == id) {
                parking.setCapacity(parking.getCapacity() - size);
                break;
            }
        }
    }

    public static ParkingLot returnLot(int id) {
        for (ParkingLot parking : parkinglot) {
            if (parking.getId() == id) {
                return parking;
            }
        }
        return null;
    }
//    public static void updateLotOne(int id, int size) {
//        for (ParkingLot parking : parkinglot) {
//            if (parking.getId()== 1) {
//                parking.setSize(parking.getSize() + size);
//                break;
//            }
//        }
//    }
//
//    public static void updateLotTwo(int id, int size) {
//        for (ParkingLot parking : parkinglot) {
//            if (parking.getId()== 2) {
//                parking.setSize(parking.getSize() + size);
//                break;
//            }
//        }
//    }

}