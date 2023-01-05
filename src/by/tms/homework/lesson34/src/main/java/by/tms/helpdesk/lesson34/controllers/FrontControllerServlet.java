package by.tms.helpdesk.lesson34.controllers;

import by.tms.helpdesk.lesson34.controllers.command.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "frontControllerServlet", urlPatterns = {"/"})
public class FrontControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FrontCommand command = getGetRequestCommand(request.getRequestURI());
        command.init(getServletContext(), request, response);
        command.process();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FrontCommand command = getPostRequestCommand(request.getRequestURI());
        command.init(getServletContext(), request, response);
        command.process();
    }

    private FrontCommand getGetRequestCommand(String requestURL) {
        return switch (requestURL) {
            case "/home/" -> new GetHomePage();
            case "/login" -> new GetLoginPageCommand();
            case "/logout" -> new LogOutCommand();
            case "/registration" -> new GetRegistrationPage();
            case "/tickets" -> new GetTicketsPageCommand();
            case "/users" -> new GetAllUsersPage();
            default -> new NotFoundCommand();
        };
    }

    private FrontCommand getPostRequestCommand(String requestURL) {
        return switch (requestURL) {
            case "/login" -> new LoginUserCommand();
            case "/registration" -> new RegistrateUserCommand();
            default -> new NotFoundCommand();
        };
    }
}
