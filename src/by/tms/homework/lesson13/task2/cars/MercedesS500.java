package by.tms.homework.lesson13.task2.cars;

import java.util.Objects;

public class MercedesS500 extends Car {

    private boolean security;

    public MercedesS500(String brand, String model, int releaseYear, int carWeight, boolean longModel, boolean security) {
        super(brand, model, releaseYear, carWeight, longModel);
        this.security = security;
    }

    public boolean isSecurity() {
        return security;
    }

    public void setSecurity(boolean security) {
        this.security = security;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MercedesS500 that = (MercedesS500) o;
        return security == that.security;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), security);
    }

    @Override
    public String toString() {
        return "MercedesS500{" +
                "security=" + security +
                "} " + super.toString();
    }
}
