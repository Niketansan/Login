package Registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class MysqlReg {
	public Connection getConnection() throws ClassNotFoundException, SQLException {

		
		Class.forName("com.mysql.jdbc.Driver");// register the driver 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "Hawkeye0");

		return con;
	} 
	public  int  insertCustomerData(String username,String name,String email,String phone,String city,String password)  {
		int i = 0;
		try {
			PreparedStatement stmt = getConnection().prepareStatement("insert into Registration values(?,?,?,?,?,?,?)");
			stmt.setInt(1, 2);
			stmt.setString(2,username);  
			stmt.setString(3,name);  
			stmt.setString(4,email);  
			stmt.setString(5,phone);  
			stmt.setString(6,city); 
			stmt.setString(7,password); 
	

			i=stmt.executeUpdate();  
			System.out.println(i+" records inserted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	
		return i;

	}
}
