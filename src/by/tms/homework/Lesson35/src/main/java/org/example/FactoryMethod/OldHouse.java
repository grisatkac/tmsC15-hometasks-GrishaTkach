package org.example.FactoryMethod;

import lombok.ToString;

@ToString(callSuper = true)
public class OldHouse extends House{

    public OldHouse() {
        setName("Old house");
    }
}
