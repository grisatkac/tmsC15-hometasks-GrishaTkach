package by.tms.homework.lesson18.domain.devices;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Monitor extends Device {

    private double diagonal;

    @JsonCreator
    public Monitor(
            @JsonProperty("diagonal") double diagonal,
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("origin") String origin,
            @JsonProperty("price") double price,
            @JsonProperty("type") Type type,
            @JsonProperty("critical") boolean critical) {
        super(id, name, origin, price, type, critical);
        this.diagonal = diagonal;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Monitor monitor = (Monitor) o;
        return Double.compare(monitor.diagonal, diagonal) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), diagonal);
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "diagonal=" + diagonal +
                "} " + super.toString();
    }
}
