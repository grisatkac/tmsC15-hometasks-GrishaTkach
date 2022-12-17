package by.tms.helpdesk.lesson34.controllers.command;

import by.tms.helpdesk.lesson34.entities.role.Role;
import by.tms.helpdesk.lesson34.entities.role.RoleValues;
import by.tms.helpdesk.lesson34.entities.user.User;
import by.tms.helpdesk.lesson34.services.user.UserService;
import by.tms.helpdesk.lesson34.services.user.UserServiceImpl;
import by.tms.helpdesk.lesson34.utils.log.LogUtil;

import javax.servlet.ServletException;
import java.io.IOException;

public class RegistrateUserCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        User candidateUser = new User(
                request.getParameter("name"),
                request.getParameter("surname"),
                request.getParameter("email"),
                request.getParameter("password"),
                true,
                new Role(RoleValues.USER),
                null
        );

        UserService userService = new UserServiceImpl();
        User registeredUser = userService.registrateUser(candidateUser);

        if (registeredUser != null) {
            LogUtil.printInfo("SUCCESS LOGIN");
            response.sendRedirect("/login");
        } else {
            LogUtil.printInfo("FAIL LOGIN");
            response.sendRedirect("/registration");
        }
    }
}
