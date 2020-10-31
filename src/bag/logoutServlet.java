package bag;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="logoutServlet", urlPatterns = {"/logoutServlet/*"})
public class logoutServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        HttpSession session=request.getSession();
        PrintWriter writer= response.getWriter();
        if(session.getAttribute("login")==null)
        {
            writer.println("please login first.");
        }
        else
        {
            session.removeAttribute("login");
            writer.println("logout successfully!");
        }
    }
}
