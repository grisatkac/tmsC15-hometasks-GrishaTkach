package com.example.lesson26.servlets;

import com.example.lesson26.pojo.Identity;
import com.example.lesson26.pojo.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet(name = "name = \"saveServlet\", urlPatterns = {\"/save\"}")
public class SaveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("Save.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> formParameters = new HashMap<>(request.getParameterMap());

        boolean isEmptyFields = formParameters.entrySet()
                .stream()
                .anyMatch(field -> {
                    for (String value : field.getValue()) {
                        if (value.length() == 0) {
                            return true;
                        }
                    }
                    return false;
                });

        if (isEmptyFields) {
            response.sendRedirect("/save");
        } else {
            Map<Identity, Item> allData = (Map<Identity, Item>) request.getSession().getAttribute("allData");
            Item item = new Item(
                    request.getParameter("name"),
                    Integer.parseInt(request.getParameter("amount")),
                    Integer.parseInt(request.getParameter("price"))
            );

            allData.put(item.getId(), item);
            request.getRequestDispatcher("Data.jsp").forward(request, response);
        }
    }

}
