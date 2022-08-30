package by.tms.homework.lesson19.scientist;

import by.tms.homework.lesson19.dump.Dump;

import java.util.Map;

public class ScientistThread extends Thread {

    public static int AMOUNT_OF_NIGHTS = 100;
    private final Dump dump;
    private final Scientist scientist;

    public ScientistThread(Dump dump, Scientist scientist) {
        this.dump = dump;
        this.scientist = scientist;
    }

    @Override
    public void run() {

        for (int i = 0; i < AMOUNT_OF_NIGHTS; i++) {
            int amountOfDetails = (int)Math.floor(Math.random()*(4) + 1);
            Map<String, Integer> detailsFromDump = dump.getRandomDetails(amountOfDetails);
            scientist.setDetailsFromDump(detailsFromDump);
            scientist.makeRobots();
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
