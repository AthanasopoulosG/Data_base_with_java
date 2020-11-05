package data_base_access;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class InfoBackup {
	
	String data[] = new String[4];
	 void main() {
		
		try {
			
			Connection con = DataBaseConnection.initializeDatabase();
			
			// sql statement
			PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE barcode=?");
			InsertData bcode = new InsertData();
	    	
	    	int code = bcode.getbarcode(); 
	    	data[0] = String.valueOf(code);
	    	
	    	ps.setInt(1, code);
	    	
	    	// get data from database and set it to rs variable
	    	ResultSet rs = ps.executeQuery();
	    	
	    	int i=2;
	    	if(rs.next()) {
	    		while(i<5) {
		    		data[i-1] = rs.getString(i);
		    		i++;
	    		}
	    	}
	    	
	    	ps.close(); 
	    	con.close();
	    	//end of try block	
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
		//end of try-catch block
		
	}
	
	 //returning data function
	public String[] reciever() {
		main();
;		return data;
	}
	//end of class
}

