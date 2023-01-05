package by.tms.helpdesk.lesson34.controllers.command;

import by.tms.helpdesk.lesson34.entities.user.User;
import by.tms.helpdesk.lesson34.services.user.UserService;
import by.tms.helpdesk.lesson34.services.user.UserServiceImpl;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

public class GetAllUsersPage extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        UserService userService = new UserServiceImpl();

        List<User> users = userService.getAll();
        request.setAttribute("users", users);
        request.getRequestDispatcher("users.jsp").forward(request,response);
    }
}
