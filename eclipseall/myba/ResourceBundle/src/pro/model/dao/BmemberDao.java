package pro.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import pro.model.dto.Bmember;

public class BmemberDao {
	private FactoryDao factory = FactoryDao.getinstance();
	private static BmemberDao instance = new BmemberDao();
	
	private ResourceBundle bundle;
	
	private BmemberDao() {
		bundle = ResourceBundle.getBundle("conf/query");
	}
	
	public static BmemberDao getInstance() {
		return instance;
	}
	
	/**
	 * <pre>
	 * 아이디 중복 확인
	 * </pre>
	 * @param id
	 * @return 있을시 true, 없을시 false
	 */
	public boolean isM_id(String id) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		//String sql = "SELECT M_ID FROM BMEMBER WHERE M_ID=?";
		String sql = bundle.getString("bmember.idCheck");
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(rs, pst, con);
		}
		return false;
	}
	
	/**
	 * <pre>
	 * 닉네임 중복 확인
	 * </pre>
	 * @param nick
	 * @return 있을시 true, 없을시 false
	 */
	public boolean isM_nick(String nick) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		//String sql = "SELECT M_NICK FROM BMEMBER WHERE M_NICK=?";
		String sql = bundle.getString("bmember.nickCheck");
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, nick);
			rs = pst.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(rs, pst, con);
		}
		return true;
	}

	/**
	 * <pre>
	 * 회원 등록
	 * </pre>
	 * @param DTO
	 * @return 성공1, 실패 0
	 */
	public int insert(Bmember DTO) {
		Connection con = null;
		PreparedStatement pst = null;
		//String sql = "INSERT INTO BMEMBER VALUES (?,?,?,?,?,?,?,?,?,1,?)";
		String sql = bundle.getString("bmember.insert");
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, DTO.getmId());
			pst.setString(2, DTO.getmPw());
			pst.setString(3, DTO.getmName());
			pst.setString(4, DTO.getmNick());
			pst.setString(5, DTO.getmBirth());
			pst.setString(6, DTO.getmPhone());
			pst.setString(7, DTO.getmMail());
			pst.setString(8, DTO.getmGender());
			pst.setString(9, DTO.getmAddress());
			//pst.setInt(10, DTO.getM_quest());
			pst.setString(10, DTO.getmAnswer());
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
	 * 회원 삭제
	 * </pre>
	 * @param m_id
	 * @return 성공 1, 실패 0
	 */
	public int delete(String m_id) {
		Connection con = null;
		PreparedStatement pst = null;
		//String sql = "DELETE FROM BMEMBER WHERE m_id=?";
		String sql = bundle.getString("bmember.delete");
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, m_id);
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
	 * 로그인 시
	 * </pre>
	 * @param id
	 * @return 성공: 아이디, 비밀번호, 닉네임  실패: null
	 */
	public HashMap selectlogin(String id) {
		HashMap hm = new HashMap<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		//String sql = "SELECT m_id, m_pw, m_nick FROM BMEMBER WHERE m_id=?";
		String sql = bundle.getString("bmember.login");
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				String sid = rs.getString("m_id");
				String spw = rs.getString("m_pw");
				String snick = rs.getString("m_nick");
				hm.put(sid, new Bmember(sid, spw, snick));
			}
			return hm;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(rs, pst, con);
		}
		return hm;
	}
	
	/**
	 * <pre>
	 * 아이디 찾기
	 * </pre>
	 * @param name
	 * @return 해당 이름을 가진 모든 회원 정보
	 */
	public ArrayList selectId(String name) {
		ArrayList al = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		//String sql = "SELECT m_id, m_name, to_char(m_birth,'yyyyMMdd')\"m_birth\", m_answer FROM BMEMBER WHERE m_name=?";
		String sql = bundle.getString("bmember.idSearch");
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			while (rs.next()) {
				String sid = rs.getString("m_id");
				String sname = rs.getString("m_name");
				String sbirth = rs.getString("m_birth");
				String sanswer = rs.getString("m_answer");
				al.add(new Bmember(sid, sname, sbirth, sanswer));
			}
			return al;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(rs, pst, con);
		}
		return al;
	}
	
	/**
	 * <pre>
	 * 비밀번호 찾기
	 * </pre>
	 * @param id
	 * @return 해당 아이디를 가진 회원정보
	 */
	public ArrayList selectPw(String id) {
		ArrayList al = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		//String sql = "SELECT m_id, m_pw, m_name, to_char(m_birth,'yyyyMMdd')\"m_birth\", m_answer FROM BMEMBER WHERE m_id=?";
		String sql = bundle.getString("bmember.pwSearch");
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				String sid = rs.getString("m_id");
				String spw = rs.getString("m_pw");
				String sname = rs.getString("m_name");
				String sbirth = rs.getString("m_birth");
				String sanswer = rs.getString("m_answer");
				al.add(new Bmember(sid, spw, sname, sbirth, sanswer));
			}
			return al;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(rs, pst, con);
		}
		return al;
	}
}
