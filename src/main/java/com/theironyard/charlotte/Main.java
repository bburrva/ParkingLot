package com.theironyard.charlotte;

import jodd.json.*;
import spark.Spark;

import java.util.ArrayList;

import static spark.Spark.before;

public class Main {
    private static ArrayList<ParkingLot> parkinglots = new ArrayList<>();
    private static ArrayList<Car> lot0 = new ArrayList<>();
    private static ArrayList<Car> lot1 = new ArrayList<>();
    private static ArrayList<Car> lot2 = new ArrayList<>();

    private static JsonParser parser = new JsonParser();
    private static JsonSerializer serializer = new JsonSerializer();
    public static void main(String[] args) {
        parkinglots.add(new ParkingLot(0, 20, 6, lot0));
        parkinglots.add(new ParkingLot(1, 15, 5, lot1));
        parkinglots.add(new ParkingLot(2, 30, 7, lot2));

        String port = System.getenv("PORT");
        if (port != null) {
            Spark.port(Integer.valueOf(port));
        }

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
        });

        Spark.get("/parking-lot", ((request, response) -> {
            System.out.println("Your api was poked or something.");
            return serializer.deep(true).serialize(parkinglots);
        }));

        Spark.post("/update", ((request, response) -> {
            Car car = parser.parse(request.body(), Car.class);

            if (car.getSize() <= returnLot(car.getId()).getCapacity() && car.getRate() >= (returnLot(car.getId()).getCost() * car.getSize())) {
                updateLot(car);

            } else if((car.getSize() > returnLot(car.getId()).getCapacity())){
                System.out.println("car doesn't fit");
                return "";
            } else if(car.getRate() < (returnLot(car.getId()).getCost() * car.getSize())) {
                System.out.println("Car doesn't have enough money");
                return "";
            }

            System.out.println("Lot " + car.getId() + " updated");
            System.out.println(parkinglots);
            return "";
        }));
    }

    public static void updateLot(Car thisCar) {
        for (ParkingLot lot : parkinglots) {
            if (lot.getId() == thisCar.getId()) {
                lot.setCapacity(lot.getCapacity() - thisCar.getSize());
                lot.getCars().add(thisCar);

                break;
            }
        }
    }

    public static ParkingLot returnLot(int id) {
        for (ParkingLot lot : parkinglots) {
            if (lot.getId() == id) {
                return lot;
            }
        }
        return null;
    }
}