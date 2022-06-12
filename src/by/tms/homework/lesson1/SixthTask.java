package by.tms.homework.lesson1;

public class SixthTask {
    public static void main(String[] args) {
        System.out.println(changeLetter('п', 3));
    }

    static char changeLetter(char russianLetter, int countOfMovement) {
        int valueNumber = russianLetter;
        char letterAfterMove = (char)(valueNumber + countOfMovement);

        return letterAfterMove;
    }
}
