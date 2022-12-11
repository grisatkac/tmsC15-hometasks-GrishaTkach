package by.tms.helpdesk.lesson34.controllers.servlets;

import by.tms.helpdesk.lesson34.entities.user.User;
import by.tms.helpdesk.lesson34.services.user.UserService;
import by.tms.helpdesk.lesson34.services.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "logOut", urlPatterns = {"/logout"})
public class LogOutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
