package com.cihan.sp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cihan.sp.model.User;

public class UserDAO {
	
	public User getUserForName(String userName) throws SQLException {
	ConnectionManager temp = ConnectionManager.getIntance();
	Connection conn = temp.getConnection();
	Statement stmt=conn.createStatement();
	String sql = " select id ,username, password from usr  where username= '" + userName + "'";
	ResultSet rs=stmt.executeQuery(sql);
	User usr=null;
	if(rs.next()) {
		usr= new User();
		usr.setUsername(rs.getString("username"));
		usr.setPassword(rs.getString("password"));
		usr.setId(rs.getInt("id"));
	}
	
	return usr;

}
	
	public List<User> getAllUsers(User usr) throws SQLException {
		List<User> users = new ArrayList<User>();
		ConnectionManager temp = ConnectionManager.getIntance();
		Connection conn = temp.getConnection();
		Statement stmt = conn.createStatement();
		String sql = " select id ,username, password from usr ";
		System.out.println(sql);
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println(sql);

		while (rs.next()) {
			User nusr = new User();
			nusr.setUsername(rs.getString("username"));
			nusr.setPassword(rs.getString("password"));
			nusr.setId(rs.getInt("id"));
			users.add(nusr);
		}

		return users;
	}

	
}
