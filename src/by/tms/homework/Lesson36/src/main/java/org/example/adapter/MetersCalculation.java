package org.example.adapter;

public class MetersCalculation implements Calculationable {

    private Integer size;

    public MetersCalculation() {}

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public void measureSize(Integer measuredSize) {
        this.size = measuredSize;
    }
}
