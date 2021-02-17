package Pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String User = request.getParameter("User");
        String Pass = request.getParameter("Pass");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection Cnt = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB","root","12345");
            Statement Stmt = Cnt.createStatement();
            
            String sql = "SELECT User FROM UserInfo WHERE User = '" + User + "' " + "AND Pass = '" + Pass + "' ";
            ResultSet rs = Stmt.executeQuery(sql);
            if(rs.next()){
                RequestDispatcher Dispatch=request.getRequestDispatcher("Welcome.jsp");
                Dispatch.forward(request, response);
            }
            else{
                RequestDispatcher Dispatch=request.getRequestDispatcher("Login.jsp?Err=yes");
                Dispatch.forward(request, response);
            } 
            Stmt.close();
            Cnt.close();
        }
        catch(Exception e){
            e.printStackTrace(); 
        }

    }

}
