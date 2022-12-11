package org.example.AbstractFactory;

import lombok.ToString;

@ToString(callSuper = true)
public class ModernHouse extends House {

    public ModernHouse(HouseFactory factory) {
        setName("Old house");
        setDoor(factory.addDoor().toString());
        setRoof(factory.addRoof().toString());
        setWall(factory.addWall().toString());
    }
}
