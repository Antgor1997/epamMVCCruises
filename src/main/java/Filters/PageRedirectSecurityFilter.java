package Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/views/*"},initParams = {@WebInitParam(name = "redirect",value = "/index.jsp")})
public class PageRedirectSecurityFilter implements Filter {

    private String indexPath;

    public void init(FilterConfig filterConfig) throws ServletException {
        indexPath = filterConfig.getInitParameter("redirect");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse) servletResponse;
        //переход на заданную страницу
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+indexPath);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {
    }
}
