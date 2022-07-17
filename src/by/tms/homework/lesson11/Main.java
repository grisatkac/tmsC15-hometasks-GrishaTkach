package by.tms.homework.lesson11;

public class Main {
    public static void main(String[] args) {
        try {
            ExceptionUtils.generateNullPointerException(null);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        int returnedValue = ExceptionUtils.generateAndCatchArrayIndexOutOfBoundsException(15);
        System.out.println("Returned value from 4.2 task" + returnedValue);

        try {
            ExceptionUtils.generateIllegalArgumentException(null, "");
        } catch (IllegalArgumentException e) {
            System.out.println("Exception message from 4.3 task: " + e.getMessage());
        }

        try {
            ExceptionUtils.throwCustomNegativeArraySizeException(-1);
        } catch (CustomUnCheckedException e) {
            System.out.println("Message of exception exception from 4.4 task " + e.getMessage());
        }

        try {
            ExceptionUtils.throwOneOfTheThreeException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        int result = -1;
        try {
            result = ExceptionUtils.generateExceptionWithHalfChance();

        } catch (ArithmeticException e) {
            e.printStackTrace();
        } finally {
            System.out.println("result of operation: " + result);
        }
    }
}

