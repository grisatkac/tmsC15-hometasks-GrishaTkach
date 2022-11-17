package by.tms.homework.lesson27.servlets;

import by.tms.homework.lesson27.pojo.Course;
import by.tms.homework.lesson27.utils.Constants;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CourseServlet", value = "/courseServlet")
public class CourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Course> attribute = (List<Course>)request.getServletContext().getAttribute(Constants.COURSES_ATTRIBUTE);
        request.getRequestDispatcher("courses.jsp").forward(request, response);
    }
}
