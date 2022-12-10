package by.tms.helpdesk.lesson34.controllers.servlets;

import by.tms.helpdesk.lesson34.entities.role.Role;
import by.tms.helpdesk.lesson34.entities.role.RoleValues;
import by.tms.helpdesk.lesson34.entities.user.User;
import by.tms.helpdesk.lesson34.services.user.UserService;
import by.tms.helpdesk.lesson34.services.user.UserServiceImpl;
import by.tms.helpdesk.lesson34.utils.log.LogUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registration", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
