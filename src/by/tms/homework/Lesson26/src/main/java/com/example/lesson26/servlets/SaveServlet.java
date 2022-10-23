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
        boolean isEmptyFields = checkIfTheFieldsIsEmpty(request);

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

    public static boolean checkIfTheFieldsIsEmpty(HttpServletRequest request) {
        List<String> formValues = new ArrayList<>();
        formValues.add(request.getParameter("name"));
        formValues.add(request.getParameter("amount"));
        formValues.add(request.getParameter("price"));
        return formValues.contains("");
    }

}
