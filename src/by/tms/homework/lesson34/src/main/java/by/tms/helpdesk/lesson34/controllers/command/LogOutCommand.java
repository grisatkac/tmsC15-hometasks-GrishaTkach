package by.tms.helpdesk.lesson34.controllers.command;

import by.tms.helpdesk.lesson34.entities.user.User;
import by.tms.helpdesk.lesson34.services.user.UserService;
import by.tms.helpdesk.lesson34.services.user.UserServiceImpl;

import javax.servlet.ServletException;
import java.io.IOException;

public class LogOutCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        User token = (User) request.getSession().getAttribute("Bearer");
        User user = userService.logOut(token);
        if (user != null) {
            response.sendRedirect("/login");
        } else {
            response.sendRedirect("home");
        }
    }
}
