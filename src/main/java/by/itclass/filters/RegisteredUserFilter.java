package by.itclass.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

import static by.itclass.constants.AppConstant.*;
import static by.itclass.constants.JSPConstant.*;

@WebFilter({LOGIN_JSP, LOGIN_CONTROLLER, REGISTRATION_CONTROLLER,REGISTRATION_JSP})
public class RegisteredUserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var session = ((HttpServletRequest) servletRequest).getSession();
        var user = session.getAttribute(USER_ATTR);
        if (Objects.nonNull(user)) {
            servletRequest.getRequestDispatcher(HOME_JSP).forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
