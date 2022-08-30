package by.tms.homework.lesson19.scientist;

import by.tms.homework.lesson19.utils.DumpUtil;

import java.util.*;

public class Scientist {
    public final String[] typesOfDetails = DumpUtil.typesOfDetails;
    private final Map<String, Integer> details = new HashMap<>();
    private int amountOfRobots;
    private String name;

    public Scientist(String name) {
        this.name = name;
        this.amountOfRobots = 0;
        initTypesOfDetails();
    }

    public void initTypesOfDetails() {
        for (String type : typesOfDetails) {
            details.put(type, 0);
        }
    }

    public void setDetailsFromDump(Map<String, Integer> detailsFromDump) {
        Set<Map.Entry<String, Integer>> entries = details.entrySet();

        for (Map.Entry<String, Integer> entry: entries) {
            if (detailsFromDump.containsKey(entry.getKey())) {
                entry.setValue(entry.getValue() + detailsFromDump.get(entry.getKey()));
            }
        }
    }

    public void makeRobots() {
        Set<Map.Entry<String, Integer>> entries = details.entrySet();
        List<Integer> values = details.values().stream().toList();
        Integer minAmountOfDetails = Collections.min(values);

        if (minAmountOfDetails > 0) {
            for (Map.Entry<String, Integer> entry: entries ) {
                if (entry.getValue() > 0) {
                    entry.setValue(entry.getValue() - minAmountOfDetails);
                }
            }
        }
        amountOfRobots += minAmountOfDetails;
    }

    public Map<String, Integer> getDetails() {
        return details;
    }

    public int getAmountOfRobots() {
        return amountOfRobots;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
