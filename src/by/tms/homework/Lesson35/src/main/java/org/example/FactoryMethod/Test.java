package org.example.FactoryMethod;

public class Test {

    public static void main(String[] args) {
        HouseFactory oldHouseFactory = new OldHouseFactory();
        HouseFactory modernHouseFactory = new ModernHouseFactory();
        House oldHouse = oldHouseFactory.createHouse();
        House modernMouse = modernHouseFactory.createHouse();

        System.out.println("Old house: " + oldHouse);
        System.out.println("Modern house: " + modernMouse);
    }
}
