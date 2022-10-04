package com.example.lesson23_24.servlets;

import com.example.lesson23_24.models.UserModel;
import com.example.lesson23_24.utils.RoleUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "students", urlPatterns = {"/app/students"})
public class StudentsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserModel> users = (List<UserModel>)request.getServletContext().getAttribute("users");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Students</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div>Studets</div>");


        users.stream()
                .filter(user -> user.getRole().equals(RoleUtils.STUDENT_ROLE))
                .forEach(student -> {
                    writer.print("<ul>");
                    writer.printf("<li>User %s</li>", student.getName());
                    writer.printf("<li>Email: %s</li>", student.getEmail());
                    writer.printf("<li>Role: %s</li>", student.getRole());
                    if (!student.getCourses().isEmpty()) {
                        writer.println("<li>Courses: ");
                        writer.print("<ul>");
                        student.getCourses().forEach(course -> {
                            writer.printf("<li>");
                            writer.print("<ol>");
                            writer.printf("<li>Language %s</li>", course.getLanguage());
                            writer.printf("<li>Language %s</li>", course.getAdditionalInfo());
                            writer.print("</ol>");
                            writer.printf("</li>");
                        });
                        writer.print("</ul>");
                        writer.write("</li>");

                    }

                    writer.print("</ul>");
                    writer.print("</body>");
                    writer.print("</html>");
                });
    }}
