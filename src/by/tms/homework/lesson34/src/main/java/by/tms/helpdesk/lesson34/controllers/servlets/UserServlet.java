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
import java.util.List;

@WebServlet(name = "users", urlPatterns = {"/users"})
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();

        List<User> users = userService.getAll();
        request.setAttribute("users", users);
        request.getRequestDispatcher("users.jsp").forward(request,response);
    }
}
