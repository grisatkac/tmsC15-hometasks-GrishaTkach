package by.tms.homework.lesson19;

import by.tms.homework.lesson19.dump.Dump;
import by.tms.homework.lesson19.factory.FactoryThread;
import by.tms.homework.lesson19.scientist.Scientist;
import by.tms.homework.lesson19.scientist.ScientistThread;
import by.tms.homework.lesson19.utils.ScientistUtil;

public class Main {

    public static void main(String[] args) {
        Dump dump = new Dump();

        FactoryThread factoryThread = new FactoryThread(dump);
        factoryThread.setName("Factory thread");
        Scientist firstScientist = new Scientist("Ivan");
        ScientistThread firstScientistThread = new ScientistThread(dump, firstScientist);
        firstScientistThread.setName("First scientist thread");

        Scientist secondScientist = new Scientist("Vasya");
        ScientistThread secondScientistThread = new ScientistThread(dump, secondScientist);
        secondScientistThread.setName("Second scientist thread");

        factoryThread.start();
        firstScientistThread.start();
        secondScientistThread.start();

        try {
            factoryThread.join();
            firstScientistThread.join();
            secondScientistThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Scientist 1. Amount of robots: " + firstScientist.getAmountOfRobots());
        System.out.println("Scientist 2. Amount of robots: " + secondScientist.getAmountOfRobots());
        System.out.println("winner is: " + ScientistUtil.compareAmountOfRobots(firstScientist, secondScientist));
    }
}
