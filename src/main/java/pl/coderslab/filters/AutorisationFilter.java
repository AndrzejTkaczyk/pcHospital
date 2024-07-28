package pl.coderslab.filters;

import pl.coderslab.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class AutorisationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest servletReq, ServletResponse servletResp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) servletReq;
        HttpServletResponse httpResp = (HttpServletResponse) servletResp;
        HttpSession sess = httpReq.getSession(false);
        String url = httpReq.getRequestURI();

        if (sess == null || sess.getAttribute("user") == null) {
            if (url.startsWith("/app")) {
                httpResp.sendRedirect("/errorLogin");
                return;
            }
        }
        else {
            User user = (User) sess.getAttribute("user");
            if (user.getAccess() == 0 && url.startsWith("/app/employee")) {
                httpResp.sendRedirect("/errorLogin");
                return;
            }
            else if (user.getAccess() == 1 && url.startsWith("/app/user")) {
                httpResp.sendRedirect("/errorLogin");
                return;
            }
        }
        chain.doFilter(httpReq, httpResp);
    }

    @Override
    public void destroy() {
    }
}
