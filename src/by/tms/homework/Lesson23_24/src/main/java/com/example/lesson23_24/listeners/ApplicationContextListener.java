package com.example.lesson23_24.listeners;

import com.example.lesson23_24.models.UserModel;
import com.example.lesson23_24.utils.UserUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.List;

@WebListener
public class ApplicationContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        List<UserModel> users = new ArrayList<>();
        UserUtil.generateStartUsers(users);
        servletContextEvent.getServletContext().setAttribute("users", users);
    }
}
