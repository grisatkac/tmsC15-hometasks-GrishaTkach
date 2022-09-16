package com.example.lesson22;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "specialDateForm", urlPatterns = {"/specialDate/form"})
public class SpecialDateFormServlet extends HttpServlet {

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
                "    <title>Date-Form</title>\n" +
                "    <style>\n" +
                "        h1 {\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "        form {\n" +
                "            display: block;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>On this page you can get some date Information</h1>\n" +
                "    <form action=\"/specialDate\">\n" +
                "        <p>Input date and after you'll get day of the week: </p>\n" +
                "        <input type=\"date\" name=\"firstDate\"/>\n" +
                "        <input type=\"submit\" value=\"submit date\" />\n" +
                "    </form>\n" +
                "\n" +
                "    <form action=\"/specialDate\">\n" +
                "        <p>Input date and after you'll get day of the week</p>\n" +
                "        <input type=\"date\" name=\"secondDate\"/>\n" +
                "        <input type=\"submit\" value=\"submit date\" />\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>");
    }
}
