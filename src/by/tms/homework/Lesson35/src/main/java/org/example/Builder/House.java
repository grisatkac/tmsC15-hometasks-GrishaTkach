package org.example.Builder;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class House {

    private String name;
    private String roof;
    private String wall;
    private String door;
    private Double height;
    private Double length;
    private Double depth;

    public static class Builder {
        private House house;

        public Builder() {
            this.house = new House();
        }

        public Builder name(String name) {
            this.house.setName(name);
            return this;
        }

        public Builder roof(String roof) {
            this.house.setRoof(roof);
            return this;
        }

        public Builder wall(String wall) {
            this.house.setWall(wall);
            return this;
        }

        public Builder door(String door) {
            this.house.setDoor(door);
            return this;
        }

        public Builder height(Double height) {
            this.house.setHeight(height);
            return this;
        }

        public Builder length(Double length) {
            this.house.setHeight(length);
            return this;
        }

        public Builder depth(Double depth) {
            this.house.setHeight(depth);
            return this;
        }

        public House build() {
            return this.house;
        }
    }
}
