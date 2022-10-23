package com.example.lesson26.servlets;

import com.example.lesson26.pojo.Identity;
import com.example.lesson26.pojo.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        if (request.getParameter("id-field").isEmpty()) {
            response.sendRedirect("/delete");
        } else {
            long id = Long.parseLong(request.getParameter("id-field"));
            Map<Identity, Item> allData = (Map<Identity, Item>) request.getSession().getAttribute("allData");

            Map<Identity, Item> allDataAfterDeleting = allData.entrySet().stream()
                    .filter(item -> item.getKey().getId() != id)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            request.getSession().setAttribute("allData", allDataAfterDeleting);
            response.sendRedirect("/list");
        }
    }
}
