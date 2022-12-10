package by.tms.helpdesk.lesson34.controllers.servlets;

import by.tms.helpdesk.lesson34.entities.user.User;
import by.tms.helpdesk.lesson34.services.user.UserService;
import by.tms.helpdesk.lesson34.services.user.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
