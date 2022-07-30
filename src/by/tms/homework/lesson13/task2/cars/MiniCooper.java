package by.tms.homework.lesson13.task2.cars;

import java.util.Objects;

public class MiniCooper extends Car {

    private boolean ultaDesing;

    public MiniCooper(String brand, String model, int releaseYear, int carWeight, boolean longModel, boolean ultaDesing) {
        super(brand, model, releaseYear, carWeight, longModel);
        this.ultaDesing = ultaDesing;
    }

    public boolean isUltaDesing() {
        return ultaDesing;
    }

    public void setUltaDesing(boolean ultaDesing) {
        this.ultaDesing = ultaDesing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MiniCooper that = (MiniCooper) o;
        return ultaDesing == that.ultaDesing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ultaDesing);
    }

    @Override
    public String toString() {
        return "MiniCooper{" +
                "ultaDesing=" + ultaDesing +
                "} " + super.toString();
    }
}
