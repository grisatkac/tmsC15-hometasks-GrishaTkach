package org.example.adapter;

public class MetersCalculationAdapter implements Calculationable {

    private CentimetersCalculation centimetersCalculation;

    public MetersCalculationAdapter(CentimetersCalculation centimetersCalculation) {
        this.centimetersCalculation = centimetersCalculation;
    }

    public Integer getSize() {
        return centimetersCalculation.getSize();
    }

    @Override
    public void measureSize(Integer measuredSize) {
        centimetersCalculation.setSize(measuredSize / 100);
    }
}
