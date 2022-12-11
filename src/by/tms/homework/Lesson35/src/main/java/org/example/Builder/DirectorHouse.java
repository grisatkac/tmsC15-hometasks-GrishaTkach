package org.example.Builder;

public class DirectorHouse {

    public House createPopularModernHouse(House.Builder builder) {
        return builder
                .name("popular modern house")
                .roof("Plastic roof")
                .wall("Plastic wall")
                .door("Plastic door")
                .height(2.2)
                .length(10.5)
                .depth(6.8)
                .build();
    }

    public House createClassicOldHouse(House.Builder builder) {
        return builder
                .name("classic old house")
                .roof("Wooden roof")
                .wall("Wooden wall")
                .door("Iron door")
                .height(2.8)
                .length(20.8)
                .depth(9.4)
                .build();

    }
}
