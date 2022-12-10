package by.tms.helpdesk.lesson34.controllers.listeners;

import by.tms.helpdesk.lesson34.entities.role.Role;
import by.tms.helpdesk.lesson34.entities.role.RoleValues;
import by.tms.helpdesk.lesson34.entities.user.User;

import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class AppListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        User user = new User("grisha", "tkach", "email", "password", true, new Role(RoleValues.USER), null);
        se.getSession().setAttribute("Bearer", user);
    }
}
