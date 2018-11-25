package film.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import film.beans.JDBC;
import film.beans.Userinfo;


public class RegisterDao {
	Connection conn = null;
	Statement s = null;
	ResultSet rs = null;
	public boolean register(Userinfo user){
		boolean flag = false;
		try {
			conn = JDBC.getConnection();
			s = conn.createStatement();

			rs = s.executeQuery("select * from userinfo where username ='"+user.getUsername()+"'");
			if(!rs.next()){
				s.execute("insert into userinfo(username,userpass,usernumber,usermoney) values('"+user.getUsername()+"','"+user.getUserpass()+"','"+user.getUsernumber()+"','"+user.getUsermoney()+"')");
				flag =true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
