package com.example.lesson23_24.servlets;

import com.example.lesson23_24.models.UserModel;
import com.example.lesson23_24.utils.ErrorUtil;
import com.example.lesson23_24.utils.UserUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        List<UserModel> users = (List<UserModel>)request.getServletContext().getAttribute("users");
        boolean correctLogin = UserUtil.loginUser(users, email, password, request);

        if (!correctLogin) {
            ErrorUtil.generateIncorrectLoginMessage(response);
        } else {
            response.sendRedirect("/app/userInfo");
        }
    }
}
