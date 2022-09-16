package com.example.lesson22;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet(name = "dateAndTime", urlPatterns = {"/dateAndTime"})
public class CustomDateAndTimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        writer.println(String.format("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "    <style>\n" +
                "        h1, p, time {\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Information about current date and time</h1>\n" +
                "    <p>Local date</p>\n" +
                "    <p><time>%s</time></p>\n" +
                "    <p>Local time</p>\n" +
                "    <p><time>%s</time></p>\n" +
                "</body>\n" +
                "</html>", currentDate, currentTime));
    }
}
