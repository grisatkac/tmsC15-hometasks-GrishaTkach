package by.tms.helpdesk.lesson34.controllers.command;

import by.tms.helpdesk.lesson34.entities.user.User;
import by.tms.helpdesk.lesson34.services.user.UserService;
import by.tms.helpdesk.lesson34.services.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginUserCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserService service = new UserServiceImpl();
        User login = service.login(email, password);

        if (login != null) {
            HttpSession session = request.getSession();
            session.setAttribute("Bearer",  login);
            response.sendRedirect("/home");
        } else {
            response.sendRedirect("/login");
        }
    }
}
