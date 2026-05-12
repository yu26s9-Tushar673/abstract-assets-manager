package com.pluralsight;

import java.util.ArrayList;

public class Main {
    static void main() {
        ArrayList<Asset> assets = new ArrayList<>();

        assets.add(new House("Vacation Home", "2019-03-15", 180000.00, "456 Beach Rd, Miami", 2, 1400, 6000));
        assets.add(new Vehicle("Classic Car",      "2008-07-19", 22000.00, "Honda Civic",       2008, 210000));
        assets.add(new Vehicle("Tushar's Car", "2021-01-20", 23000.00,"Subaru Forester", 2014,87000));
        assets.add(new Cash("Mattress Stash", "2022-06-07", 5000.00));

        System.out.println("----------- Asset Report -----------\n");

        for (Asset asset : assets) {
            System.out.println("Description  : " + asset.getDescription());
            System.out.println("Date Acquired: " + asset.getDateAcquired());
            System.out.printf("Original Cost: $%,.2f%n", asset.getOriginalCost());
            System.out.printf("Current Value: $%,.2f%n", asset.getValue());

            if (asset instanceof House) {
                House house = (House) asset;  // downcast
                System.out.println("Address      : " + house.getAddress());
                System.out.println("Condition    : " + house.getCondition());
                System.out.println("Square Feet  : " + house.getSquareFoot());
                System.out.println("Lot Size     : " + house.getLotSize() + " sq ft");
            } else if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset;
                System.out.println("Year/Model   : " + vehicle.getYear() + " " + vehicle.getMakeModel());
                System.out.println("Odometer     : " + String.format("%,d", vehicle.getOdometer()) + " miles");
            }
            System.out.println("------------------------------------");
        }
    }
}
