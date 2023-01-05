package org.example.AbstractFactory;

public class ModernHouseFactory implements HouseFactory{
    @Override
    public Door addDoor() {
        return new ModernDoor();
    }

    @Override
    public Roof addRoof() {
        return new ModernRoof();
    }

    @Override
    public Wall addWall() {
        return new ModernWall();
    }
}
