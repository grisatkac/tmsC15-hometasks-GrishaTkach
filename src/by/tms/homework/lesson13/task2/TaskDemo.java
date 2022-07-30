package by.tms.homework.lesson13.task2;

import by.tms.homework.lesson13.task2.cars.MercedesS500;
import by.tms.homework.lesson13.task2.cars.MiniCooper;
import by.tms.homework.lesson13.task2.garage.Garage;

public class TaskDemo {
    public static void main(String[] args) {
        MercedesS500 mercedesS500 = new MercedesS500("Mecedes", "s500", 2020, 15, true, true);
        MercedesS500 mercedesS5001 = new MercedesS500("Mecedes", "s500", 2021, 15, true, true);
        MiniCooper miniCooper = new MiniCooper("mino cooper", "bbbx", 2022, 10, false, true );
        MiniCooper miniCooper1 = new MiniCooper("mino cooper", "cx", 2022, 10, false, true );
        Garage carGarage = new Garage();

        carGarage.parkAutoInGarage(mercedesS500);
        carGarage.parkAutoInGarage(mercedesS500);
        carGarage.parkAutoInGarage(miniCooper);
        carGarage.parkAutoInGarage(miniCooper1);
        System.out.println(carGarage.getGarageCars());

        carGarage.goOutFromGarage(mercedesS500);
        System.out.println(carGarage.getGarageCars());

        carGarage.parkAutoInGarage(mercedesS500);
        System.out.println(carGarage.calcCountSomeCars(mercedesS5001));
        System.out.println(carGarage.calcCountSomeCars(mercedesS500));
        System.out.println(carGarage.getGarageCars());
    }
}
