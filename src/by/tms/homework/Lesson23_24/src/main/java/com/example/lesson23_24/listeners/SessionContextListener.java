package com.example.lesson23_24.listeners;

import com.example.lesson23_24.models.UserModel;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionContextListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        System.out.println("session created");

        UserModel token = (UserModel)sessionEvent.getSession().getAttribute("Bearer");
        if (token != null) {
            System.out.println("In session saved user token");
            System.out.println("Information about user");
            System.out.println(token.toString());
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session has been destroyed");
    }
}
