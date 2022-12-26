package by.tms.tkach.lesson40.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;


public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
        root.scan("by.tms.tkach.springmvc");
        servletContext.addListener(new ContextLoaderListener(root));
        DispatcherServlet dispatcherServlet = new DispatcherServlet(new GenericWebApplicationContext());
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        ServletRegistration.Dynamic appServlet = servletContext.addServlet("appServlet",
                dispatcherServlet);
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/");
    }
}
