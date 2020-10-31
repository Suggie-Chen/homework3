package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "loginFilter",urlPatterns = {"/loginServlet/*"})
public class loginFilter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request =(HttpServletRequest)req;
        HttpServletResponse response =(HttpServletResponse)resp;
        HttpSession session=request.getSession();
        if(session.getAttribute("login")==null)
        {
            response.sendRedirect(request.getContextPath()+"/login.html");
        }
        else
        {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}