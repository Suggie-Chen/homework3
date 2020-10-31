package bag;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="doneServlet", urlPatterns = {"/doneServlet/*"})
public class doneServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Integer a=(Integer)request.getAttribute("a");
        Integer b=(Integer)request.getAttribute("b");
        Integer c=a+b;
        PrintWriter writer=response.getWriter();
        writer.println(c);
    }
}
