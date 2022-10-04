package com.example.lesson23_24.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public final class ErrorUtil {

    public ErrorUtil() {}

    public static void generateIncorrectLoginMessage(HttpServletResponse response) {
        response.setContentType("text/html");
        response.setStatus(400);
        try {
            response.getWriter().write("<h1>Incorrect data in login form</h1>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void generateIncorrectRegistrationFields(HttpServletResponse response) {
        response.setContentType("text/html");
        response.setStatus(400);
        try {
            response.getWriter().write("<h1>Incorrect value of fields in registration form</h1>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void generateIncorrectCourseFields(HttpServletResponse response){
        response.setContentType("text/html");
        response.setStatus(400);
        try {
            response.getWriter().write("<h1>Incorrect value of fields in course form</h1>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
