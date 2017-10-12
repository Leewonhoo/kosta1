package work.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import work.model.dto.Blogin;
import work.model.dto.Bmember;

public class BlogDao {
	private FactoryDao factory = FactoryDao.getinstance();
	private static BlogDao instance = new BlogDao();
	
	private BlogDao() {	}
	
	public static BlogDao getInstance() {
		return instance;
	}
	
	/**
	 * <pre>
	 * blogin �Է�
	 * </pre>
	 * @param id
	 * @return ���� 1, ���� 0
	 */
	public int insert(String id) {
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "INSERT INTO blogin(l_id, l_start, l_status, l_ip) VALUES (?,sysdate,'R','192.168.0.1')";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			return pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(pst, con);
		}
		return 0;
	}
	
	/**
	 * <pre>
	 * blogin ���̺� �α׾ƿ��� ������Ʈ
	 * </pre>
	 * @param status
	 * @param id
	 * @return ����1 ����0
	 */
	public int loupdate(String status, String id) {
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "UPDATE blogin SET l_end=sysdate, l_status=? WHERE l_id=? AND l_end IS NULL";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, status);
			pst.setString(2, id);
			return pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(pst, con);
		}
		return 0;
	}
	
}
