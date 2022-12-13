package org.example.adapter;

public class Test {

    public static void main(String[] args) {
        CentimetersCalculation centimetersCalculation = new CentimetersCalculation();

        MetersCalculationAdapter metersCalculationAdapter = new MetersCalculationAdapter(centimetersCalculation);
        metersCalculationAdapter.measureSize(10000);
        System.out.println("Converted measured size from centimeters to meters using adapter : "+ metersCalculationAdapter.getSize());
    }
}
