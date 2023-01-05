package by.tms.tkach.lesson38.task1;

import by.tms.tkach.lesson38.task1.entity.user.User;
import by.tms.tkach.lesson38.task1.service.user.UserService;
import by.tms.tkach.lesson38.task1.service.user.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationConfig.xml");
        UserService userService = applicationContext.getBean("userService", UserServiceImpl.class);
        User user = userService.getById(1L);
        System.out.println(user);
    }
}
