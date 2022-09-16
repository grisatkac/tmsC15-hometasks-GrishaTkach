package com.example.lesson22;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;


@WebServlet(name = "specialDate", urlPatterns = {"/specialDate"})
public class SpecialDateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstDate = request.getParameter("firstDate");
        String secondDate = request.getParameter("secondDate");
        String resultDate;

        if (firstDate != null && !firstDate.isEmpty()) {
            resultDate = String.format("Day of the week: %s", LocalDate.parse(firstDate).getDayOfWeek());
        } else if(secondDate != null && !secondDate.isEmpty()) {
            resultDate = String.format("Day of the year: %s", LocalDate.parse(secondDate).getDayOfYear());
        } else {
            resultDate = "Empty";
        }

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        writer.println(String.format("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>DateAndTime</title>\n" +
                "    <style>\n" +
                "        h1, p {\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Information about special time</h1>\n" +
                "    <p>%s</p>\n" +
                "</body>\n" +
                "</html>", resultDate));
    }
}
