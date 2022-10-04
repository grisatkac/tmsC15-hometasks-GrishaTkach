package com.example.lesson23_24.servlets;

import com.example.lesson23_24.utils.ErrorUtil;
import com.example.lesson23_24.utils.UserUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "course-form", urlPatterns = {"/app/courseForm/*"})
public class CourseFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("CourseForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isAddedCourse = UserUtil.addCourseForUser(request);

        if (isAddedCourse) {
            response.sendRedirect("/app/userInfo");
        } else {
            ErrorUtil.generateIncorrectCourseFields(response);
        }
    }
}
