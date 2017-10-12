package work.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * Factory DAO
 * -- DAO Pattern
 * -- Singleton Pattern
 * -- Connection Pool : javax.sql.DataSource;
 * 
 * @author kosta
 *
 */
public class FactoryDao {

	private static FactoryDao instance = new FactoryDao();
	//Connection Pool
	private DataSource ds;

	private FactoryDao(){
		
		try {
			Context context = new InitialContext();
			//java:comp/env : codedName
			// context.xml : <Resource name="jdbc/Oracle">
			ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	

	public static FactoryDao getInstance() {
		return instance;
	}

	public Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 *  CUD �ڿ�����
	 * @param conn
	 * @param stmt
	 */
	public void close(Connection conn, PreparedStatement pstmt) {
		
		close(conn, pstmt, null);
	}
	
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�ڿ� ���� ����!!!!");
		}
	}
	
}
