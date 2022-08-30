package by.tms.homework.lesson19.dump;

import by.tms.homework.lesson19.utils.DumpUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Dump {
    public static final int START_AMOUNT_OF_DETAILS = DumpUtil.START_AMOUNT_OF_DETAILS;
    public static final String[] typesOfDetails = DumpUtil.typesOfDetails;
    private static final Map<String, Integer> details = new HashMap<>();
    private final Object LOCK = new Object();

    public Dump() {
        initTypesOfDetails();
        setRandomDetails(START_AMOUNT_OF_DETAILS);
    }

    public static void initTypesOfDetails() {
        for (String type : typesOfDetails) {
            details.put(type, 0);
        }
    }

    public void setRandomDetails(int amountOfRandomDetails) {
        synchronized (LOCK) {
            Set<Map.Entry<String, Integer>> entries = details.entrySet();

            for (int i = 0; i < amountOfRandomDetails; i++) {
                int randomPositionOfTypeDetail = (int)Math.floor(Math.random()*(typesOfDetails.length));

                for (Map.Entry<String, Integer> entry: entries) {
                    if (entry.getKey().equals(typesOfDetails[randomPositionOfTypeDetail])) {
                        entry.setValue(entry.getValue() + 1);
                    }
                }
            }
        }
    }

    public Map<String, Integer> getRandomDetails(int amountOfRandomDetails) {
        synchronized (LOCK) {
            Set<Map.Entry<String, Integer>> entries = details.entrySet();
            boolean inNotEmptyValues = !details.values().stream().allMatch(value -> value == 0);

            if (inNotEmptyValues) {
                Map<String, Integer> detailsForScientistsFromDump = new HashMap<>();
                for (int i = 0; i < amountOfRandomDetails; i++) {
                    int randomPositionOfTypeDetail = (int)Math.floor(Math.random()*(typesOfDetails.length));

                    entries.forEach(e -> {
                        if (e.getKey().equals(typesOfDetails[randomPositionOfTypeDetail]) && e.getValue() > 0) {
                            e.setValue(e.getValue() - 1);
                            detailsForScientistsFromDump.merge(e.getKey(), 1, Integer::sum);
                        }
                    });
                }
                return detailsForScientistsFromDump;
            }
        }
        return new HashMap<>();
    }
}
