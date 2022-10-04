package com.example.lesson23_24.filters;

import com.example.lesson23_24.models.UserModel;
import com.example.lesson23_24.utils.RoleUtils;

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
        UserModel token = (UserModel) request.getSession().getAttribute("Bearer");
        String requestURI = request.getRequestURI();

        if (token == null) {
            if (RoleUtils.publicUrls.contains(requestURI)) {
                chain.doFilter(request, response);
            } else {
                response.sendRedirect("/login");
            }
        } else {
            boolean isRoleHaveAccessToUrl = RoleUtils.validateRoleForUrl(requestURI, token.getRole());

            if (!isRoleHaveAccessToUrl) {
                response.sendRedirect("/app/userInfo");
            } else {
                chain.doFilter(request,response);
            }
        }
    }
}
