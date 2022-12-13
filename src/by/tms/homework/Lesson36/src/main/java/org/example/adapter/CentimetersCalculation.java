package org.example.adapter;

public class CentimetersCalculation implements Calculationable {

    private Integer size;

    public CentimetersCalculation() {}

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
