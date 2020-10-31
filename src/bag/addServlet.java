package bag;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

@WebServlet(name="addServlet", urlPatterns = {"/addServlet/*"})
public class addServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String uri=request.getRequestURI();
        String[] urisp=uri.split("/");
        String template="^a=(-?[0-9]+)&b=(-?[0-9]+)$";
        Pattern p=Pattern.compile(template);
        if(urisp.length!=4)
        {
            PrintWriter writer=response.getWriter();
            writer.println("error format!");
        }
        else
        {
            Matcher m= p.matcher(urisp[3]);
            Integer anum=Integer.parseInt(m.group(1));
            Integer bnum=Integer.parseInt(m.group(2));
            if(m.find())
            {
                request.setAttribute("a",anum);
                request.setAttribute("b",bnum);
                request.getRequestDispatcher("/doneServlet").forward(request,response);
            }
            else
            {
                PrintWriter writer=response.getWriter();
                writer.println("parameters error");
            }
        }
    }
}
