package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JDBCUtil {
	//connection,close,rollback,commit
	public static Connection getConnection() {
		Connection conn=null;
		
		try {
			Context ctx= new InitialContext();
			DataSource ds =(DataSource)ctx.lookup("java:comp/env/jdbc/Oracle");
			conn= ds.getConnection();
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(ResultSet rs) {		
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement ps) {		
		try {
			if(ps != null)
				ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static void close(Connection conn) {		
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	public static void commit(Connection conn) {
		try {
			conn.commit();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
}
















