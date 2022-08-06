package by.tms.homework.lesson14.task1;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class task1 {

    public static void main(String[] args) {
        List<Integer> listOfNumbers = List.of(1, 2, 3, 4, 1, 2, 3, 4);
        Optional<String> stream = Stream.of(listOfNumbers)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .map(String::valueOf)
                .reduce((firstNumber, secondNumber) -> firstNumber + secondNumber);
        if (stream.isPresent()) {
            System.out.println(stream.get());
        }
    }
}
