package br.teste.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	
	private static Connection con;
	
	public static Connection getConnection() throws Exception {
		if (con == null || con.isClosed()){
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/UNIBH", "unibh", "1234");
		}
		return con;
	}

	
	public static void closedConnection() throws Exception {
		if (con != null && !con.isClosed()){
			con.close();
		}
	}
}
