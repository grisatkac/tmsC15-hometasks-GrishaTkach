package com.example.lesson26.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        if (sessionEvent.getSession().getAttribute("allData") == null) {
            List<Map<String, String[]>> allData = new ArrayList<>();
            sessionEvent.getSession().setAttribute("allData", allData);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        List<Map<String, String[]>> allData = (ArrayList<Map<String, String[]>>)sessionEvent.getSession().getAttribute("allData");
        allData.clear();
    }
}
