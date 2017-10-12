package pro.model.dao;

import java.util.HashMap;
import java.util.ResourceBundle;

import org.apache.ibatis.session.SqlSession;

import pro.model.dto.Blogin;

public class BlogDao {
	private FactoryDao factory = FactoryDao.getinstance();
	private static BlogDao instance = new BlogDao();
	
	private ResourceBundle bundle;
	
	private BlogDao() {
		bundle = ResourceBundle.getBundle("conf/query");
	}
	
	public static BlogDao getInstance() {
		return instance;
	}
	
	/**
	 * <pre>
	 * blogin 입력
	 * </pre>
	 * @param id
	 * @return 성공 1, 실패 0
	 */
	public int insert(String id) {
		SqlSession session = factory.openSession(true);
		int result = 0;
		try {
			result = session.selectOne("blogInsert", id);
		} finally {
			session.close();
		}
		return result;
		
//		Connection con = null;
//		PreparedStatement pst = null;
//		//String sql = "INSERT INTO blogin(l_id, l_start, l_status, l_ip) VALUES (?,sysdate,'R','192.168.0.1')";
//		String sql = bundle.getString("blog.insert");
//		try {
//			con = factory.getConnection();
//			pst = con.prepareStatement(sql);
//			pst.setString(1, id);
//			return pst.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			factory.close(pst, con);
//		}
//		return 0;
	}
	
	/**
	 * <pre>
	 * blogin 테이블 로그아웃시 업데이트
	 * </pre>
	 * @param status
	 * @param id
	 * @return 성공1 실패0
	 */
	public int loupdate(String status, String id) {
		SqlSession session = factory.openSession(true);
		int result = 0;
		try {
			Blogin log = new Blogin();
			log.setlStatus(status);
			log.setlId(id);
			result = session.selectOne("blogUpdate", log);
		} finally {
			session.close();
		}
		return result;
		
//		Connection con = null;
//		PreparedStatement pst = null;
//		//String sql = "UPDATE blogin SET l_end=sysdate, l_status=? WHERE l_id=? AND l_end IS NULL";
//		String sql = bundle.getString("blog.insert");
//		try {
//			con = factory.getConnection();
//			pst = con.prepareStatement(sql);
//			pst.setString(1, status);
//			pst.setString(2, id);
//			return pst.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			factory.close(pst, con);
//		}
//		return 0;
	}
	
}
