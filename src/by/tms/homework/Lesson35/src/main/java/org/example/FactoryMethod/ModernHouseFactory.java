package org.example.FactoryMethod;

public class ModernHouseFactory implements HouseFactory {

    @Override
    public House createHouse() {
        return new ModernHouse();
    }
}
