package by.tms.helpdesk.lesson34.controllers.command;

import javax.servlet.ServletException;
import java.io.IOException;

public class GetLoginPageCommand extends FrontCommand {

    @Override
    public void process() throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
