package by.tms.helpdesk.lesson34.controllers.command;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class FrontCommand {
    protected ServletContext servletContext;
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    public void init(ServletContext servletContext, HttpServletRequest request, HttpServletResponse response) {
        this.servletContext = servletContext;
        this.request = request;
        this.response = response;
    }

    public abstract void process() throws ServletException, IOException;
}
