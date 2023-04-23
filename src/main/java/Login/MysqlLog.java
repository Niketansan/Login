package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MysqlLog {  
	public static boolean validate(String username,String password){  
		boolean status=false;  
		try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "Hawkeye0");  
				
				PreparedStatement ps=con.prepareStatement("select * from Registration where username = ? and password = ? ;");  
				ps.setString(1,username); 
				ps.setString(2,password);  
				System.out.println(username+""+password);
				ResultSet rs=ps.executeQuery();  
				if (!rs.next() ) {
				    System.out.println("no data");
				} else {

				    do {
				    status = true;
				    } while (rs.next());
				}
				
				
		}catch(Exception e){
				System.out.println(e);
		}  
		return status;  
	}  
}  
