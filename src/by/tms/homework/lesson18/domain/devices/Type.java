package by.tms.homework.lesson18.domain.devices;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Type {

    private boolean isPeripheral;
    private int energyConsumption;
    private boolean haveCooler;

    @JsonCreator
    public Type(
            @JsonProperty("isPeripheral") boolean isPeripheral,
            @JsonProperty("energyConsumption") int energyConsumption,
            @JsonProperty("haveCooler") boolean haveCooler) {
        this.isPeripheral = isPeripheral;
        this.energyConsumption = energyConsumption;
        this.haveCooler = haveCooler;
    }

    public boolean isPeripheral() {
        return isPeripheral;
    }

    public void setPeripheral(boolean peripheral) {
        isPeripheral = peripheral;
    }

    public int getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(int energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    public boolean isHaveCooler() {
        return haveCooler;
    }

    public void setHaveCooler(boolean haveCooler) {
        this.haveCooler = haveCooler;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return isPeripheral == type.isPeripheral && energyConsumption == type.energyConsumption && haveCooler == type.haveCooler;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isPeripheral, energyConsumption, haveCooler);
    }

    @Override
    public String toString() {
        return "Type{" +
                "isPeripheral=" + isPeripheral +
                ", energyConsumption=" + energyConsumption +
                ", haveCooler=" + haveCooler +
                '}';
    }
}
