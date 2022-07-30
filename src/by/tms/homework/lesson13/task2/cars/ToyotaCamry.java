package by.tms.homework.lesson13.task2.cars;

import java.util.Objects;

public class ToyotaCamry extends Car {

    private boolean turbo;

    public ToyotaCamry(String brand, String model, int releaseYear, int carWeight, boolean longModel, boolean turbo) {
        super(brand, model, releaseYear, carWeight, longModel);
        this.turbo = turbo;
    }

    public boolean isTurbo() {
        return turbo;
    }

    public void setTurbo(boolean turbo) {
        this.turbo = turbo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ToyotaCamry that = (ToyotaCamry) o;
        return turbo == that.turbo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), turbo);
    }

    @Override
    public String toString() {
        return "ToyotaCamry{" +
                "turbo=" + turbo +
                "} " + super.toString();
    }
}
