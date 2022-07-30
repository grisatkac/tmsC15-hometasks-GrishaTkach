package by.tms.homework.lesson13.task2.cars;

import java.util.Objects;

public class BMW5 extends Car {

    private boolean comfortable;

    public BMW5(String brand, String model, int releaseYear, int carWeight, boolean longModel, boolean comfortable) {
        super(brand, model, releaseYear, carWeight, longModel);
        this.comfortable = comfortable;
    }

    public boolean isComfortable() {
        return comfortable;
    }

    public void setComfortable(boolean comfortable) {
        this.comfortable = comfortable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BMW5 bmw5 = (BMW5) o;
        return comfortable == bmw5.comfortable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), comfortable);
    }

    @Override
    public String toString() {
        return "BMW5{" +
                "comfortable=" + comfortable +
                "} " + super.toString();
    }
}
