package work.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class FactoryDao {
	private static FactoryDao instance = new FactoryDao();
	
	//connection pool
	private DataSource ds;
	
	/**
	 * <pre>
	 * factory dao : oracle 정보 확립
	 * </pre>
	 */
	private FactoryDao() {
		try {
			Context context = new InitialContext();
			// java:comp/env : codedName
			// context.xml : <Resource name = "jdbc/Oracle">
			ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle");
		} catch (NamingException e) {
			
		}
	}
	
	public static FactoryDao getinstance() {
		return instance;
	}
	
	/**
	 * <pre>
	 * DB 연결
	 * </pre>
	 * @return
	 */
	public Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * <pre>
	 *  연결 해제
	 * </pre>
	 * @param st
	 * @param con
	 */
	public void close(Statement st, Connection con) {
		try {
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <pre>
	 * 연결 해제
	 * </pre>
	 * @param st
	 * @param con
	 */
	public void close(ResultSet rs, Statement st, Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
