package org.example.AbstractFactory;

public class OldHouseFactory implements HouseFactory{
    @Override
    public Door addDoor() {
        return new OldDoor();
    }

    @Override
    public Roof addRoof() {
        return new OldRoof();
    }

    @Override
    public Wall addWall() {
        return new OldWall();
    }
}
