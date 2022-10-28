package by.tms.tkach;

import by.tms.tkach.pojo.Item;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testItem {

    static Item item1;
    static Item item2;

    @BeforeAll
    public static void init() {
        item1 = new Item("", 2 ,10);
        item2 = new Item("apples", 5, 10);
    }

    public static Stream<Arguments> testConstructorParams() {
        return Stream.of(
                Arguments.of(item1, false),
                Arguments.of(new Item("apples", -1, 10), false),
                Arguments.of(new Item("apples", 10, -1), false),
                Arguments.of(new Item("apples", 0 , 0), false),
                Arguments.of(item2, true)
        );
    }

    @ParameterizedTest
    @MethodSource("testConstructorParams")
    public void itemConstructorInvalidParams(Item item, boolean expectedResult) {
        boolean actualResult = true;
        if (item.getNameOfItem() == null) {
            actualResult = false;
        }

        if (item.getPrice() == 0 || item.getAmount() == 0) {
            actualResult = false;
        }

        assertEquals(expectedResult, actualResult);
    }

    public static Stream<Arguments> testGetIdReturnedValue() {
        return Stream.of(
                Arguments.of(item1, false),
                Arguments.of(item2, true)
        );
    }

    @ParameterizedTest
    @MethodSource("testGetIdReturnedValue")
    public void getId(Item item, boolean expected) {
        boolean actual = true;
        if (item.getId() == null) {
            actual = false;
        }

        assertEquals(actual, expected);
    }
}
