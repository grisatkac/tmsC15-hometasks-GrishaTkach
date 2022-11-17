package task2;

import task2.utils.UserUtil;

import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<User> users = UserUtil.generateUsers(1000);
        System.out.println(users);
        System.out.println("total users: " + users.size());
        UserUtil.getUniqueUsers(users);
    }
}
