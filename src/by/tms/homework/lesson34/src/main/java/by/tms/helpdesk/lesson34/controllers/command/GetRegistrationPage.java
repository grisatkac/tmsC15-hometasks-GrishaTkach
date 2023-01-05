package by.tms.helpdesk.lesson34.controllers.command;

import javax.servlet.ServletException;
import java.io.IOException;

public class GetRegistrationPage  extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("registration.jsp").forward(request, response);
    }
}
