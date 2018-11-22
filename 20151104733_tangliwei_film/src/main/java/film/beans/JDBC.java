package film.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
static Connection conn;
	
	static{
		try {
   			Class.forName("com.mysql.jdbc.Driver");
   			System.out.println("");
   		}catch (Exception e) {
			// TODO: handle exception
   			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/film?useUnicode=true&characterEncoding=utf-8", "root", "123456");
			System.out.println("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	

}
