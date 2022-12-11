package by.tms.helpdesk.lesson34.controllers.filters;

import by.tms.helpdesk.lesson34.entities.role.Role;
import by.tms.helpdesk.lesson34.entities.role.RoleValues;
import by.tms.helpdesk.lesson34.entities.user.User;
import by.tms.helpdesk.lesson34.utils.url.UrlAccess;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(displayName = "accessFilter", urlPatterns = {"/*"})
public class AccessFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        User token = (User) request.getSession().getAttribute("Bearer");
        String requestURI = request.getRequestURI();


        if (requestURI.contains(".css") || requestURI.contains(".ico")) {
            chain.doFilter(request, response);
        } else {
            if (token == null) {
                if (UrlAccess.validateRoleForUrl(requestURI, null)) {
                    chain.doFilter(request, response);
                } else {
                    response.sendRedirect("/login");
                }
            } else {
                boolean isRoleHaveAccessToUrl = UrlAccess.validateRoleForUrl(requestURI, token.getRole().getRoleValue());
                if (!isRoleHaveAccessToUrl) {
                    response.sendRedirect("/home");
                } else {
                    chain.doFilter(request,response);
                }
            }
        }
    }
}
