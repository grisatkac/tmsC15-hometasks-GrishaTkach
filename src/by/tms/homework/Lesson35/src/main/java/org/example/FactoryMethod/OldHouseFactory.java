package org.example.FactoryMethod;

public class OldHouseFactory implements HouseFactory {
    @Override
    public House createHouse() {
        return new OldHouse();
    }
}
