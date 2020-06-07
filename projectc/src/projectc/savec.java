package projectc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class savec {
	 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
     {  
          response.setContentType("text/html");  
          PrintWriter out = response.getWriter();  
         
          String name = request.getParameter("name");  
         
          int mobile = Integer.parseInt(request.getParameter("mobile"));
          int home = Integer.parseInt(request.getParameter("home"));
          int dob = Integer.parseInt(request.getParameter("dob"));
          String email = request.getParameter("email");  
          try
          {  
               //load the driver
               Class.forName("oracle.jdbc.driver.OracleDriver");  
               //create connection object
               Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","local","test");  
               // create the prepared statement object
               PreparedStatement ps=con.prepareStatement("insert into save values");  
 
               ps.setString(1,name);  
             
               ps.setInt(2, mobile);
               ps.setInt(3, home);
               ps.setInt(4, dob);
               ps.setString(5, email);
               int i = ps.executeUpdate();  
               if(i>0)  
               out.print("You are successfully saved");  
 
          }
          catch (Exception ex)
          {
               ex.printStackTrace();
          }  
          out.close();  
     }  

}
