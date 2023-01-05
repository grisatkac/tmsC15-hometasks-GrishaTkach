package org.example.AbstractFactory;

public class Test {

    public static void main(String[] args) {
        HouseFactory modernHouseFactory = new ModernHouseFactory();
        HouseFactory oldHouseFactory = new OldHouseFactory();

        House oldHouse = new OldHouse(oldHouseFactory);
        House modernHouse = new ModernHouse(modernHouseFactory);

        System.out.println(oldHouse);
        System.out.println(modernHouse);
    }
}
