package com.example.lesson26.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(name = "deleteServlet", urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("Delete.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("field") == null || request.getParameter("value").isEmpty()) {
            response.sendRedirect("/delete");
        } else {
            String field = request.getParameter("field");
            String value = request.getParameter("value");
            List<Map<String, String[]>> allData = (ArrayList<Map<String, String[]>>) request.getSession().getAttribute("allData");

            List<Map<String, String[]>> allDataAfterDeleting = allData.stream()
                    .filter(data -> data.entrySet().stream()
                            .anyMatch(dataField -> dataField.getKey().equals(field)
                                    && Arrays.stream(dataField.getValue()).anyMatch(val -> !(val.equals(value)))))
                    .collect(Collectors.toList());

            request.getSession().setAttribute("allData", allDataAfterDeleting);
            response.sendRedirect("/list");
        }
    }
}
