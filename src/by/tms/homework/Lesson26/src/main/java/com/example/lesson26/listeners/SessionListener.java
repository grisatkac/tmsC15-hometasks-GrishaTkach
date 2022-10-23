package com.example.lesson26.listeners;

import com.example.lesson26.pojo.Identity;
import com.example.lesson26.pojo.Item;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        if (sessionEvent.getSession().getAttribute("allData") == null) {
            Map<Identity, Item> allData = new HashMap<>();
            sessionEvent.getSession().setAttribute("allData", allData);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("Session destroyed");
    }
}
