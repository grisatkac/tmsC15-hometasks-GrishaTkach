package by.tms.homework.lesson19.utils;

import by.tms.homework.lesson19.scientist.Scientist;

public final class ScientistUtil {

    ScientistUtil() {}

    public static String compareAmountOfRobots(Scientist firstScientist, Scientist secondScientist) {
        if (firstScientist != null && secondScientist != null) {
            if (firstScientist.getAmountOfRobots() == secondScientist.getAmountOfRobots()) {
                return "Draw";
            }
            return (firstScientist.getAmountOfRobots() > secondScientist.getAmountOfRobots())?
                    firstScientist.getName(): secondScientist.getName();
        }
        return "Don't have scientists for comparing";
    }
}
