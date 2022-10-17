package by.tms.homework.lesson27.listeners;

import by.tms.homework.lesson27.pojo.Course;
import by.tms.homework.lesson27.pojo.CourseName;
import by.tms.homework.lesson27.utils.Constants;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.List;

@WebListener
public class ApplicationContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute(Constants.COURSES_ATTRIBUTE, initCourses());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        clearCoursesAttribute((List<Course>)servletContext.getAttribute(Constants.COURSES_ATTRIBUTE));
    }

    private List<Course> initCourses() {
        List<Course> courses =  new ArrayList<>();
        courses.add(new Course(CourseName.Java, 3000, 20));
        courses.add(new Course(CourseName.Go, 2999, 19));
        courses.add(new Course(CourseName.Python, 3001, 21));
        return courses;
    }

    private void clearCoursesAttribute(List<Course> courses) {
        courses.clear();
    }
}
