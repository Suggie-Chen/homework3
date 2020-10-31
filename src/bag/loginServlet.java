package bag;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class loginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String name=request.getParameter("name");
        String pwd=request.getParameter("pwd");
        PrintWriter writer=response.getWriter();
        if(name.equals("admin")&&pwd.equals("123456"))
        {
            writer.println("Success!");
            HttpSession session=request.getSession();
            session.setAttribute("login","login successfully!");//若用户名和密码都正确，则将会话的login置为login successfully!
        }
        else
        {
            writer.println("invalid login!");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
