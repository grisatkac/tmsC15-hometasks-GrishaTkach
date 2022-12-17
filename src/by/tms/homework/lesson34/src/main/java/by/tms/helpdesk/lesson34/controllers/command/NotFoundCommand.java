package by.tms.helpdesk.lesson34.controllers.command;

import javax.servlet.ServletException;
import java.io.IOException;

public class NotFoundCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("404.html").forward(request, response);
    }
}
