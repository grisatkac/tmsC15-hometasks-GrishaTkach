package by.tms.homework.lesson13.task2.cars;

import java.util.Objects;

public abstract class Car {

    private String brand;
    private String model;
    private int releaseYear;
    private int carWeight;
    private boolean longModel;

    public Car(String brand, String model, int releaseYear, int carWeight, boolean longModel) {
        this.brand = brand;
        this.model = model;
        this.releaseYear = releaseYear;
        this.carWeight = carWeight;
        this.longModel = longModel;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getCarWeight() {
        return carWeight;
    }

    public void setCarWeight(int carWeight) {
        this.carWeight = carWeight;
    }

    public boolean isLongModel() {
        return longModel;
    }

    public void setLongModel(boolean longModel) {
        this.longModel = longModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return releaseYear == car.releaseYear && carWeight == car.carWeight && longModel == car.longModel && Objects.equals(brand, car.brand) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, releaseYear, carWeight, longModel);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", releaseYear=" + releaseYear +
                ", carWeight=" + carWeight +
                ", longModel=" + longModel +
                '}';
    }
}
