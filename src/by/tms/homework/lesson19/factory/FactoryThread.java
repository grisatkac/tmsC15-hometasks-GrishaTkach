package by.tms.homework.lesson19.factory;

import by.tms.homework.lesson19.dump.Dump;

public class FactoryThread extends Thread {
    public static int AMOUNT_OF_NIGHTS = 100;
    private final Dump dump;

    public FactoryThread(Dump dump) {
        this.dump = dump;
    }

    @Override
    public void run() {
        for (int i = 0; i < AMOUNT_OF_NIGHTS; i++) {
            int amountOfDetails = (int)Math.floor(Math.random()*(4) + 1);
            dump.setRandomDetails(amountOfDetails);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
