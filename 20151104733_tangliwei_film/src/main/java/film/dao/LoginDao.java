package film.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import film.beans.JDBC;
import film.beans.Userinfo;

public class LoginDao {
	Connection conn = null;
	ResultSet rs = null;
	Statement s = null;
	public boolean login(Userinfo user){
		boolean flag = false;
		try {
			conn = JDBC.getConnection();
			s = conn.createStatement();
			rs = s.executeQuery("select * from userinfo where username ='"+user.getUsername()+"' and userpass ='"+user.getUserpass()+"'");
			if(rs.next()){
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
