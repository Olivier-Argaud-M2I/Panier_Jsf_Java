package fr.m2i.panier.filters;

import fr.m2i.panier.backed.UserBean;
import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {

    @Inject
    private UserBean userbean;


    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {


        if(!userbean.isLog()){
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect(((HttpServletRequest)request).getContextPath()+"/login.xhtml");
        }

        chain.doFilter(request, response);
    }
}
