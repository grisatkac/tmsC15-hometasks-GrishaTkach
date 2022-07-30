package by.tms.homework.lesson13.task2.garage;

import by.tms.homework.lesson13.task2.cars.BMW5;
import by.tms.homework.lesson13.task2.cars.Car;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Garage {

    private final Map<Car, Integer> garageCars = new HashMap<>();

    public Garage() {}

    public Garage(Map<Car, Integer> garageCars) {
        if (garageCars != null && garageCars.size() > 0) {
            this.garageCars.putAll(new HashMap<>(garageCars));
        }
    }

    public boolean parkAutoInGarage(Car car) {
        if (car == null) {
            return false;
        }

        if (garageCars.containsKey(car)) {
            garageCars.put(car, garageCars.get(car) + 1);
        } else {
            garageCars.put(car,  1);
        }
        return true;
    }

    public boolean goOutFromGarage(Car car) {
        boolean carGoFromGarage = false;
        if (car == null) {
            return false;
        }

        Set<Map.Entry<Car, Integer>> carSet = garageCars.entrySet();

        for(Map.Entry<Car, Integer> carFromGarage: carSet) {
            if (carFromGarage.getKey().equals(car)) {
                if (carFromGarage.getValue() - 1 == 0) {
                    garageCars.remove(carFromGarage.getKey());
                } else {
                    garageCars.put(carFromGarage.getKey(), carFromGarage.getValue() - 1);
                }
                carGoFromGarage = true;
            }
        }
        return carGoFromGarage;
    }

    public int calcCountSomeCars(Car car) {
        return (car == null || !garageCars.containsKey(car))? -1 : garageCars.get(car);
    }

    public Map<Car, Integer> getGarageCars() {
        return garageCars;
    }

    public void setGarageCars(Map<Car, Integer> garageCars) {
        this.garageCars.putAll(new HashMap<>(garageCars));
    }

    @Override
    public String toString() {
        return "Garage{" +
                "garageCars=" + garageCars +
                '}';
    }
}
