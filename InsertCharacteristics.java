package data_base_access;

import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;



  
// Servlet Name 
@WebServlet("/InsertChar") 
public class InsertCharacteristics extends HttpServlet { 
    private static final long serialVersionUID = 1L; 
    
    
    
    protected void doPost(HttpServletRequest request,  
HttpServletResponse response) 
        throws ServletException, IOException 
    { 
    	
        try { 
        	
            // Initialize the database 
        	Connection con = DataBaseConnection.initializeDatabase(); 
  
        	PreparedStatement st = con.prepareStatement("UPDATE products SET prod_name=?, prod_color=?, prod_info=? WHERE barcode=?");
        	
        	InsertData bcode = new InsertData();
        	
        	int code = bcode.getbarcode(); 
        	//System.out.println(code);
        	
        	st.setString(1, request.getParameter("name"));
        	st.setString(2, request.getParameter("color"));
        	st.setString(3, request.getParameter("Info"));
        	st.setInt(4, code);
        	
        	String name = request.getParameter("name");
        	String color = request.getParameter("color");
        	String info = request.getParameter("Info");
        	
        	//execute query
        	st.executeUpdate(); 
  
            // Close all the connections 
            st.close(); 
            con.close();
            
  
            
            //Forward  the results of database to jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("testing.jsp");
            request.setAttribute("barcode",code);
            request.setAttribute("Name", name); 
            request.setAttribute("Color", color);
            request.setAttribute("info", info);
            dispatcher.forward( request, response );
            
          
           
        }
        catch (SQLException e) {
        	
             response.sendRedirect("redirect.html");
        } 
        catch (Exception e) { 
        	String str = e.getMessage();
        	PrintWriter out = response.getWriter(); 
        	out.println("<html><body><b>"+str +"<br>Please try again " +"</b></body></html>");
        	
            e.printStackTrace(); 
        } 
    } 
}



