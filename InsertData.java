package data_base_access;

import java.io.IOException; 
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
@WebServlet("/InsertData") 
public class InsertData extends HttpServlet { 
    private static final long serialVersionUID = 1L; 
    static  int code_id;
    
    
    protected void doPost(HttpServletRequest request,  
HttpServletResponse response) 
        throws ServletException, IOException 
    { 
    	
        try { 
  
            // Initialize the database 
        	Connection con = DataBaseConnection.initializeDatabase(); 
  
            // Create a SQL query to insert data into demo table 
           
        	PreparedStatement st = con.prepareStatement("insert into products values(?,?,?,?)"); 
  
            
            st.setInt(1, Integer.valueOf(request.getParameter("barcode"))); 
            st.setString(2, "");
            st.setString(3, "");
            st.setString(4, "");
           
            code_id = Integer.valueOf(request.getParameter("barcode"));
            
            //Execute query
            st.executeUpdate(); 
  
            // Close all the connections 
            st.close(); 
            con.close(); 
            
            //link to redirect.html file to continue
            response.sendRedirect("redirect.html");
           
        }
        catch (SQLException e) {
        	// if barcode exists in database 
        	String str = "Product with same barcode already exists !!!";
        	//collect data based on a existing barcode
        	InfoBackup ibp= new InfoBackup();
        	String data[] = ibp.reciever();
        	
        	
    		//redirect to jsp with the data
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("testing.jsp");
            request.setAttribute("barcode",	data[0]	); // we can input code_id too its the same 
            request.setAttribute("Name"	, 	data[1]	); 
            request.setAttribute("Color",	data[2]	);
            request.setAttribute("info"	,	data[3]	);
            request.setAttribute("str"	,	str		);
            dispatcher.forward( request, response );
	    	            
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
    
    public int getbarcode() {
    	return code_id;
    }
    
} 
