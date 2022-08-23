package by.tms.homework.lesson18.domain.devices;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Mouse extends Device {

    private boolean wireless;

    @JsonCreator
    public Mouse(@JsonProperty("id") String id,
                 @JsonProperty("name") String name,
                 @JsonProperty("origin") String origin,
                 @JsonProperty("price") double price,
                 @JsonProperty("type") Type type,
                 @JsonProperty("critical") boolean critical,
                 @JsonProperty("wireless") boolean wireless) {
        super(id, name, origin, price, type, critical);
        this.wireless = wireless;
    }

    public boolean isWireless() {
        return wireless;
    }

    public void setWireless(boolean wireless) {
        this.wireless = wireless;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Mouse mouse = (Mouse) o;
        return wireless == mouse.wireless;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wireless);
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "wireless=" + wireless +
                "} " + super.toString();
    }
}
