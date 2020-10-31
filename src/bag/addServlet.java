package bag;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

@WebServlet(name="addServlet", urlPatterns = {"/addServlet/*"})
public class addServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out=response.getWriter();
    if(request.getParameter("a")!=null&&request.getParameter("b")!=null){
        String a=request.getParameter("a");
        String b=request.getParameter("b");
//        System.out.println(a);
//        System.out.println(b);
        if(isNumber(a)&&isNumber(b)){//如果a和b都是有效数字
//            System.out.println("Valid");
            request.setAttribute("a",Integer.valueOf(a));//设置a和b两个变量
            request.setAttribute("b",Integer.valueOf(b));
            request.getRequestDispatcher("/doneServlet").forward(request,response);//转发给doneServlet
        }
    }
    else {
        out.println("<p style='font-size:30px;font-weight:bold;'>");
        out.println("Invalid parameter");
        out.println("</p>");
    }

}
    public static boolean isNumber(String s) {
        try {
            Integer.valueOf(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}