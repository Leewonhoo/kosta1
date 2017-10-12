package work.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class FactoryDao {
	private static FactoryDao instance = new FactoryDao();

	private DataSource ds;

	private String driverName;
	private String url;
	private String userId;
	private String userPw;
	private ResourceBundle bundle;	

	/**
	 * <pre>
	 * ����̹� �� ���̵�, ��й�ȣ ��������
	 * </pre>
	 */
	private FactoryDao() {
		bundle = ResourceBundle.getBundle("conf/dbserver");
		driverName = bundle.getString("oracle.driverName");
		url = bundle.getString("oracle.url");
		userId = bundle.getString("oracle.userId");
		userPw = bundle.getString("oracle.userPw");

		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("����̹� ����");
		}
	}

	public static FactoryDao getinstance() {
		return instance;
	}

	/**
	 * <pre>
	 * DB ����
	 * </pre>
	 * @return
	 */
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(url, userId, userPw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * <pre>
	 * ��ü, ���� ����
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
	 * ��ü, ���� ����
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