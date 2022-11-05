/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.sql.Connection;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author Sukky
 */
@WebServlet(urlPatterns = {"/mydb"})
public class mydb extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         PrintWriter out=response.getWriter();
         Connection con=null;
         Statement st=null;
         String n=request.getParameter("name");
         String e=request.getParameter("email");
         String p=request.getParameter("psw");
         try
         {
                    
                     con=DriverManager.getConnection("jdbc:derby://localhost:1527/tracker");
                     st=con.createStatement();
                     st.executeUpdate("insert into reg values('"+n+"','"+e+"','"+p+")");
                     out.print("<h1> row inserted</h1>");
         }
                     
                     
         catch(Exception ex)
         {
             out.print("try again"+ex);
         }
    }


    

}
