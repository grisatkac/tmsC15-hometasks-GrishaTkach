package by.tms.homework.lesson11;

public final class ExceptionUtils {

    private ExceptionUtils() {};

    /*
    Method for 4.1 task
     */
    public static void generateNullPointerException(Object obj) {
        obj.hashCode();
    }

    /*
    Method for 4.2 task
     */
    public static int generateAndCatchArrayIndexOutOfBoundsException(int position) {
        try {
            int[] array = new int[10];
            int currentValue = array[position];
            return currentValue;

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /*
    Method for 4.3 task
     */
    public static void generateIllegalArgumentException(String name, String password) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("Uncorrect user name");
        }

        String nameOfUser = name;

        if (password.length() == 0) {
            throw new IllegalArgumentException("Password length must be more than 0");
        }

        String passwordOfUser = password;
    }

    /*
    Method for 4.4 task
     */
    public static void throwCustomNegativeArraySizeException(int arrayLength) {
        try {
            int[] array = new int[arrayLength];
        } catch (NegativeArraySizeException e) {
            throw new CustomUnCheckedException(e);
        }
    }

    /*
    Method for 4.5 task
     */
    public static void throwOneOfTheThreeException() {
        int randomValueOfException = (int) (Math.random() * 3);

        switch (randomValueOfException){
            case 0:
                int a = 1 / 0;
                break;
            case 1:
                int[] arr = new int[10];
                int value = arr[10];
                break;
            case 2:
                String str = "hello world!";
                char letter = str.charAt(str.length() + 1);
                break;
        }
    }

    /*
    Method for 4.6 task
     */
    public static int generateExceptionWithHalfChance() {
        int valueForGenerateException = (int)(Math.random() * 2);
        int value = 0;

        if (valueForGenerateException >= 1) {
            value = 1 / 0;
        } else {
            value = 1 / 1;
        }
        return value;
    }
}
