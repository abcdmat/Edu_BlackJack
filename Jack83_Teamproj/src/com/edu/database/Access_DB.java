package com.edu.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Access_DB {

	public Access_DB() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@192.168.1.126:1521:xe";
		String user = "sqld";
		String password = "sqld";
		conn = DriverManager.getConnection(url, user, password);
		// TODO Auto-generated catch block


		return conn;
	}

	public void close(Connection conn, PreparedStatement stmt, ResultSet rs) {

		try {
			if(rs != null) {
				rs.close();
			}if(stmt != null) {
				stmt.close();
			}if(conn != null) {
				conn.close();
			}
			System.out.println("6. close Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
