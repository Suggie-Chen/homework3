package bag;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="loginServlet", urlPatterns = {"/loginServlet/*"})
public class loginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String name=request.getParameter("name");
        String pwd=request.getParameter("pwd");
        PrintWriter writer=response.getWriter();
        if(name.equals("admin")&&pwd.equals("123456"))
        {
            writer.println("Success!");
            HttpSession session=request.getSession();
            session.setAttribute("login","login successfully!");
        }
        else
        {
            writer.println("invalid login!");
        }
    }
}
