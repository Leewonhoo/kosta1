package work.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import work.Dto.BoardDto;
import work.Dto.MemberDto;

public class MemberDao {
	private FactoryDao factory = FactoryDao.getinstance();
	private static MemberDao instance = new MemberDao();
	
	private MemberDao() { }
	
	public static MemberDao getInstance() {
		return instance;
	}
	
	/**
	 * <pre>아이디 중복 확인</pre>
	 * @param id
	 * @return 있을시 true, 없을시 false
	 */
	public boolean isM_id(String id) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT C_ID FROM CUSTOMER WHERE C_ID=?";
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
	 * <pre>회원 등록</pre>
	 * @param DTO
	 * @return 성공1, 실패 0
	 */
	public int insert(MemberDto DTO) {
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "INSERT INTO CUSTOMER VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,0,0)";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, DTO.getId());
			pst.setString(2, DTO.getPw());
			pst.setString(3, DTO.getkName());
			pst.setString(4, DTO.geteLastName());
			pst.setString(5, DTO.geteFristName());
			pst.setString(6, DTO.getSex());
			pst.setString(7, DTO.getBirth());
			pst.setString(8, DTO.getNation());
			pst.setString(9, DTO.getMobile());
			pst.setString(10, DTO.getEmail());
			pst.setString(11, DTO.geteCheck());
			pst.setString(12, DTO.getSms());
			pst.setString(13, "");
			pst.setString(14, "silver");
			return pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(pst, con);
		}
		return 0;
	}
	
	/**
	 * <pre>회원정보 업데이트</pre>
	 * @param DTO
	 * @return 성공 : 1 , 실패 : 0
	 */
	public int inforUpdate(MemberDto DTO) {   //회원 업뎃
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "UPDATE CUSTOMER SET C_NATION=?, C_MOBILE=?, C_EMAIL=?, "
				+ "C_EMAILCH=?, C_MOBILECH=?, C_ADDRESS=? WHERE C_ID=?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, DTO.getNation());
			pst.setString(2, DTO.getMobile());
			pst.setString(3, DTO.getEmail());
			pst.setString(4, DTO.geteCheck());
			pst.setString(5, DTO.getSms());
			pst.setString(6, DTO.getAddress());
			pst.setString(7, DTO.getId());
			return pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(pst, con);
		}
		return 0;
	}
	
	/**
	 * <pre>비밀번호 확인</pre>
	 * @param DTO
	 * @return 성공 : 1 , 실패 : 0
	 */
	public boolean isM_pw(String id, String guPw) {   //회원 업뎃
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT C_ID FROM CUSTOMER WHERE C_ID=? AND C_PW=?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, guPw);
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
	 * <pre>비밀번호 업데이트</pre>
	 * @param DTO
	 * @return 성공 : 1 , 실패 : 0
	 */
	public int passUpdate(String id, String newPw) {   //회원 업뎃
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "UPDATE CUSTOMER SET C_PW=? WHERE C_ID=?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, newPw);
			pst.setString(2, id);
			return pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(pst, con);
		}
		return 0;
	}
	
	/**
	 * <pre>회원 삭제</pre>
	 * @param m_id
	 * @return 성공 1, 실패 0
	 */
	public int delete(String id) {
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "DELETE FROM CUSTOMER WHERE c_id=?";
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
	 * <pre>로그인 시</pre>
	 * @param id
	 * @return 성공: 아이디, 비밀번호, 닉네임  실패: null
	 */
	public String login(String id, String pw) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String sql = "SELECT c_id FROM CUSTOMER WHERE c_id=? and c_pw=?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);
			rs = pst.executeQuery();
			while (rs.next()) {
				return rs.getString("c_id");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(rs, pst, con);
		}
		return null;
	}
	
	/**
	 * <pre>개인 정보 호출</pre>
	 * @param dto
	 * @return
	 */
	public MemberDto myInfor(String userId, String userPw) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT C_ID, C_PW, C_KNAME, C_ELNAME, C_EFNAME, C_SEX, "
				+ "to_char(C_BIRTH,'yyyy\"년\" mm\"월\" dd\"일\"')\"C_BIRTH\", C_NATION, C_MOBILE, C_EMAIL, C_EMAILCH, C_MOBILECH, "
				+ "C_ADDRESS, C_GRADE, C_MILE, TOTALMILE FROM CUSTOMER WHERE c_id=? and c_pw=?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, userId);
			pst.setString(2, userPw);
			rs = pst.executeQuery();
			while (rs.next()) {
				String id = rs.getString("C_ID");
				String pw = rs.getString("C_PW");
				String kname = rs.getString("C_KNAME");
				String elname = rs.getString("C_ELNAME");
				String efname = rs.getString("C_EFNAME");
				String sex = rs.getString("C_SEX");
				String birth = rs.getString("C_BIRTH");
				String nation = rs.getString("C_NATION");
				String mobile = rs.getString("C_MOBILE");
				String email = rs.getString("C_EMAIL");
				String emailCh = rs.getString("C_EMAILCH");
				String mobileCh = rs.getString("C_MOBILECH");
				String address = rs.getString("C_ADDRESS");
				String grade = rs.getString("C_GRADE");
				int mile = rs.getInt("C_MILE");
				int totalMile = rs.getInt("TOTALMILE");
				return new MemberDto(id, pw, kname, elname, efname, birth, sex, nation, 
						mobile, email, mobileCh, emailCh, address, grade, mile, totalMile);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(rs, pst, con);
		}
		return null;
	}
	
	/**
	 * <pre>아이디 찾기</pre>
	 * @param name
	 * @return 해당 이름을 가진 모든 회원 정보
	 */
	public String selectId(String name, String mobile) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT C_ID FROM customer WHERE C_KNAME=? and C_MOBILE=?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, mobile);
			rs = pst.executeQuery();
			while (rs.next()) {
				return rs.getString("c_id");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(rs, pst, con);
		}
		return null;
	}
	
	/**
	 * <pre>비밀번호 찾기</pre>
	 * @param name
	 * @return 해당 이름을 가진 모든 회원 정보
	 */
	public boolean selectPw(String id, String name, String mobile) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT C_ID FROM CUSTOMER WHERE C_ID=? and C_KNAME=? and C_MOBILE=?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, name);
			pst.setString(3, mobile);
			rs = pst.executeQuery();
			return rs.next();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(rs, pst, con);
		}
		return false;
	}
	
	/**
	 * <pre>비밀번호 재설정</pre>
	 * @param id
	 * @param pw
	 * @return
	 */
	public int updatePw(String id, String pw) {
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "UPDATE CUSTOMER SET C_PW=? WHERE C_ID=?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, pw);
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