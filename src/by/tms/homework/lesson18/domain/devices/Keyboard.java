package by.tms.homework.lesson18.domain.devices;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Keyboard extends Device {

    private boolean mechanical;

    @JsonCreator
    public Keyboard(@JsonProperty("id") String id,
                    @JsonProperty("name") String name,
                    @JsonProperty("origin") String origin,
                    @JsonProperty("price") double price,
                    @JsonProperty("type") Type type,
                    @JsonProperty("critical") boolean critical,
                    @JsonProperty("mechanical") boolean mechanical) {
        super(id, name, origin, price, type, critical);
        this.mechanical = mechanical;
    }

    public boolean isMechanical() {
        return mechanical;
    }

    public void setMechanical(boolean mechanical) {
        this.mechanical = mechanical;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Keyboard keyboard = (Keyboard) o;
        return mechanical == keyboard.mechanical;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mechanical);
    }
}
