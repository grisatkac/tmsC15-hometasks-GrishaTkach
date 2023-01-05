package org.example.FactoryMethod;

import lombok.ToString;

@ToString(callSuper = true)
public class ModernHouse extends House{

    public ModernHouse() {
        setName("Modern house");
    }
}
