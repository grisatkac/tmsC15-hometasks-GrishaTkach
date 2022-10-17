package by.tms.homework.Lesson33;

import by.tms.homework.Lesson33.pojo.User;
import by.tms.homework.Lesson33.utils.UserUtils;

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        User firstUser = UserUtils.createUser("Greg", "Greg", 25, 777);
        User secondUser = UserUtils.createUser("Ivan", "Ivanov", 25, 777);
        User thirdUser = UserUtils.createUser("Greg", "Greg", 25, 777);
        System.out.println("Before deep copy: ");
        System.out.println(firstUser);

        User fourthUser = User.cloneUser(UserUtils.CLONE_TYPE.DEEP.toString(), firstUser.getId());
        firstUser.setId(5L);

        System.out.println("After copy: ");
        System.out.println(firstUser);
        System.out.println(fourthUser);

        compareTwoUsers(firstUser, secondUser);
        compareTwoUsers(firstUser, thirdUser);

        String firstWord = "Book";
        String secondWord = "Book";
        String thirdWord = new String("Book");
        String fourthWord = new String("Book");

        compareTwoStringUsingEqual(firstWord, secondWord);
        compareTwoStringUsingEqual(firstWord, thirdWord);
        compareTwoStringUsingEqual(thirdWord, fourthWord);

        compareTwoStringUsingEqualRelationalOperator(firstWord, secondWord);
        compareTwoStringUsingEqualRelationalOperator(firstWord, thirdWord);
        compareTwoStringUsingEqualRelationalOperator(thirdWord, fourthWord);

        int firstValue = 127;
        int secondValue = 127;
        Integer thirdValue = new Integer(127);
        Integer fourthValue = Integer.valueOf(127);
        Integer fifthValue = Integer.valueOf(127);


        System.out.println(firstValue == secondValue);
        System.out.println(firstValue == thirdValue);
        System.out.println(fourthValue.equals(firstValue));
        System.out.println(thirdValue == fourthValue);
        System.out.println(fourthValue == fifthValue);
    }

    public static void compareTwoUsers(User firstUser, User secondUser) {
        System.out.println(String.format("Comparing two users: \n %s \n and  %s \n Result of comparing is: %s"
                , firstUser.toString(), secondUser.toString(), firstUser.equals(secondUser)  ));
    }

    public static void compareTwoStringUsingEqual(String firstString, String secondString) {
        if (firstString.equals(secondString)) {
            System.out.println("This strings are equal");
        } else {
            System.out.println("This strings are not equal");
        }
    }

    public static void compareTwoStringUsingEqualRelationalOperator(String firstString, String secondString) {
        if (firstString == secondString) {
            System.out.println("This strings are equal");
        } else {
            System.out.println("This strings are not equal");
        }
    }
}
