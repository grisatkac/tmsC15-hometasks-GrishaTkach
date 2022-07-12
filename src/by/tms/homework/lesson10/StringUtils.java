package by.tms.homework.lesson10;

public final class StringUtils {
    private static final String ROMANIAN_LETTERS = "IVXLCDM";
    private static final int[] ROMANIAN_VALUES = {1, 5, 10, 50, 100, 500, 1000};
    private static final String[] NOT_VALID_LETTERS = {"VV", "LL", "DD", "IIII", "XXXX", "CCCC", "MMMM"};

    private StringUtils() {}

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isPalindrom(String str) {
        if (isEmpty(str)) {
            return false;
        }

        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static int convertRomanianNumberToArabian(String romanianNumber) {
        int arabianNumber = 0;
        int currentIndex;
        int currentValue;
        int prevIndex;
        int prevValue;

        if (!isValidRomanianNumber(romanianNumber)) {
            return arabianNumber;
        }

        romanianNumber = handleString(romanianNumber);

        if (romanianNumber.length() > 1) {
            for (int i = 1; i < romanianNumber.length(); i++) {
                currentIndex = ROMANIAN_LETTERS.indexOf(romanianNumber.charAt(i));
                prevIndex = ROMANIAN_LETTERS.indexOf(romanianNumber.charAt(i - 1));
                currentValue = ROMANIAN_VALUES[currentIndex];
                prevValue = ROMANIAN_VALUES[prevIndex];

                if (prevValue < currentValue) {
                    arabianNumber += currentValue - prevValue;
                } else {
                    if (i != romanianNumber.length() - 1) {
                        arabianNumber += prevValue;
                    } else {
                        arabianNumber += prevValue + currentValue;
                    }
                }
            }

        } else {
            arabianNumber =  ROMANIAN_VALUES[ROMANIAN_LETTERS.indexOf(romanianNumber.charAt(0))];
        }

        return arabianNumber;
    }

    private static boolean isValidRomanianNumber(String romanianNumber) {
        boolean isValid = true;

        if (isEmpty(romanianNumber)) {
            return false;
        }

        if (romanianNumber.trim().contains(" ")) {
            return false;
        }

        for (String notValidLetter : NOT_VALID_LETTERS) {
            if (romanianNumber.contains(notValidLetter)) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    private static String handleString(String str) {
        return str.trim();
    }
}
