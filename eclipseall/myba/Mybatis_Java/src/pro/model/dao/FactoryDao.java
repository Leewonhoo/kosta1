package pro.model.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FactoryDao {
	private static FactoryDao instance = new FactoryDao();
	
	private String driverName;
	private String url;
	private String userId;
	private String userPw;
	private ResourceBundle bundle;
	
	private static SqlSessionFactory sessionFactory;
	
	static {
		String resource = "resources/mybatis_conf.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			System.out.println(">>> sessionFactory : " + sessionFactory);
		} catch (Exception e) {
			System.out.println("Error Message : " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch(IOException e) {
				System.out.println("Error Message : " + e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	public SqlSession openSession() {
		//return sessionFactory.openSession();
		return openSession(false);
	}
	
	public SqlSession openSession(boolean result) {
		return sessionFactory.openSession(result);
	}
	
	/**
	 * <pre>
	 * 드라이버 및 아이디, 비밀번호 가져오기
	 * </pre>
	 */
	private FactoryDao() {
//		bundle = ResourceBundle.getBundle("conf/db");
//		driverName = bundle.getString("oracle.driverName");
//		url = bundle.getString("oracle.url");
//		userId = bundle.getString("oracle.userId");
//		userPw = bundle.getString("oracle.userPw");
//		try {
//			Class.forName(driverName);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
//	
	public static FactoryDao getinstance() {
		return instance;
	}
//	
//	/**
//	 * <pre>
//	 * DB 연결
//	 * </pre>
//	 * @return
//	 */
//	public Connection getConnection() {
//		try {
//			return DriverManager.getConnection(url, userId, userPw);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	/**
//	 * <pre>
//	 * 객체, 연결 끊기
//	 * </pre>
//	 * @param st
//	 * @param con
//	 */
//	public void close(Statement st, Connection con) {
//		try {
//			if (st != null) {
//				st.close();
//			}
//			if (con != null) {
//				con.close();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	/**
//	 * <pre>
//	 * 객체, 연결 끊기
//	 * </pre>
//	 * @param st
//	 * @param con
//	 */
//	public void close(ResultSet rs, Statement st, Connection con) {
//		try {
//			if (rs != null) {
//				rs.close();
//			}
//			if (st != null) {
//				st.close();
//			}
//			if (con != null) {
//				con.close();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
}
