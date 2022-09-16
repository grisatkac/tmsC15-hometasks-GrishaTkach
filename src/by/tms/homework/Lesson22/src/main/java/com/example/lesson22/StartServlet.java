package com.example.lesson22;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "startServlet", urlPatterns = {"/"})
public class StartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Servlet</title>\n" +
                "    <style>\n" +
                "        h1, p, a {\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Hi!</h1>\n" +
                "    <p>Click on the first link if you want to get current date and time: </p>\n" +
                "    <p><a href=\"/dateAndTime\">Get current date</a></p>\n" +
                "\n" +
                "    <p>Click on the second link if you want to get day of the week or day of the year</p>\n" +
                "    <p><a href=\"/specialDate/form\">Get day of week of day of the year</a></p>\n" +
                "</body>\n" +
                "</html>");
    }
}
