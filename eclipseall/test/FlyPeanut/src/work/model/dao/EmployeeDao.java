package work.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import work.model.dto.EmployeeDto;
import work.util.Utility;

public class EmployeeDao {
	
	private FactoryDao factory = FactoryDao.getInstance();
	private static EmployeeDao instance = new EmployeeDao();
	
	private EmployeeDao() {}
	
	public static EmployeeDao getInstance() {
		return instance;
	}
	
	/**
	 * 로그인
	 * @param eId
	 * @param ePw
	 * @return
	 */
	public String login(String eId, String ePw) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		
		// select e_kname from employee where e_id=123456 and e_pw='password';
		String sql = "select e_kname from employee where e_id=? and e_pw=?";

		try {
			conn = factory.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, eId);
			pstm.setString(2, ePw);
			rs = pstm.executeQuery();

			if (rs.next()) {
				return rs.getString("e_kname");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : 회원 로그인 오류");
		} finally {
			factory.close(conn, pstm);
		}
		return null;
	}
	
	/**
	 * 회원가입
	 * @param eId
	 * @param ePw
	 * @param eKname
	 * @param eEfname
	 * @param eElname
	 * @param eSex
	 * @param eBirth
	 * @param eMobile
	 * @param eEmail
	 * @return
	 */
	public int join(String eId,String ePw,String eKname,String eEfname,String eElname,String eSex,String eBirth,String eMobile,String eEmail,String eAddress,String eState) {
		
		Connection conn = null;
		PreparedStatement pstm = null;

		String sql = "insert into EMPLOYEE values(?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			conn = factory.getConnection();
			pstm = conn.prepareStatement(sql);// 미완성 정적 sql통로

			pstm.setString(1, eId);
			pstm.setString(2, ePw);
			pstm.setString(3, eKname);
			pstm.setString(4, eEfname);
			pstm.setString(5, eElname);
			pstm.setString(6, eSex);
			pstm.setString(7, eBirth);
			pstm.setString(8, eMobile);
			pstm.setString(9, eEmail);
			pstm.setString(10, eAddress);
			pstm.setString(11, eState);
			
			return pstm.executeUpdate(); 

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : 회원등록오류");

		}finally {
			factory.close(conn, pstm);
		}
		return 0;
	}
	
	/**
	 * 임시비밀번호로 비밀번호 변경
	 * @param eId
	 * @param eKname
	 * @param eBirth
	 * @param eEmail
	 * @return 임시발급 변경 암호 문자열
	 */
	public String resetPassword(String eId, String eKname, String eBirth, String eEmail) {
		Connection conn = null;
		PreparedStatement pstm = null;
		
		Random r = new Random();
		//int pw = r.nextInt(10000); //임시비밀번호 발생
		//String tmpPw = Utility.getSecureAlphaString(6);
		String tmpPw2 = Utility.getSecureNumberString(6);
		//long tmpPw3 = Utility.getSecureNumber(8);
		
		String sql = "update employee set e_pw=? where e_id=? and e_kname=? and e_birth=? and e_email=?";
		//System.out.println(tmpPw2);
		//System.out.println(tmpPw3 * 100);
		
		try {
			conn = factory.getConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, tmpPw2);
			pstm.setString(2, eId);
			pstm.setString(3, eKname);
			pstm.setString(4, eBirth);
			pstm.setString(5, eEmail);
			
			if(pstm.executeUpdate()==1) {
				return tmpPw2;  				
			}else {
				System.out.println("error : 직원 임시비밀번호로 변경 오류");				
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : SQL 실행구문 오류!");
		} finally {
			factory.close(conn, pstm);
		}
		return null;
	}
	
	/**
	 * 내정보보기(마이페이지)
	 * @param eId
	 * @return
	 */
	public EmployeeDto myInfo(String eId) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		
		//select * from employee where e_id='123456';
		String sql = "select e_pw , e_kname , e_efname ,e_elname, e_sex , to_char(e_birth, 'yyyy. mm. dd.') \"e_birth\" , e_mobile , e_email , e_address from employee where e_id=?";

		try {
			conn = factory.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, eId);
			rs = pstm.executeQuery();
			if (rs.next()) {
				String ePw = rs.getString("e_pw");
				String eKname = rs.getString("e_kname");
				String eEfname = rs.getString("e_efname");
				String eElname = rs.getString("e_elname");
				String eSex = rs.getString("e_sex");
				String eBirth = rs.getString("e_birth");
				String eMobile = rs.getString("e_mobile");
				String eEmail = rs.getString("e_email");
				String eAddress = rs.getString("e_address");
			
				return new EmployeeDto(eId, ePw, eKname, eEfname, eElname, eSex,
						eBirth, eMobile, eEmail,eAddress);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : 내정보 보기 조회 오류");
		}finally {
			factory.close(conn, pstm,rs);
		}
		return null;
	}
	
	/**
	 * 비밀번호 체크 (비밀번호 변경 전)
	 * @param eId
	 * @param ePw
	 * @return 맞으면true 틀리면false
	 */
	public boolean checkPw(String eId,String ePw) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		
		//select * from employee where e_id='123456';
		String sql = "select * from employee where e_id=? and e_pw=?";

		try {
			conn = factory.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, eId);
			pstm.setString(2, ePw);
			rs = pstm.executeQuery();
			return rs.next();
				
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : 내 비밀번호 확인 조회 오류");
		}finally {
			factory.close(conn, pstm,rs);
		}
		return false;
	}
	
	/**
	 * 비밀번호 변경
	 * @param eId
	 * @param ePw
	 * @return 성공 1 실패 0
	 */
	public int updatePassword(String eId,String ePw) {
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		String sql = "update employee set e_pw=?  where e_id=?";
		
		try {
			conn = factory.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, ePw);
			pstm.setString(2, eId);
			
			return pstm.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : 비밀번호 변경 오류");
		}
		finally {
			factory.close(conn, pstm);
		}
		return 0;
	}
	
	/**
	 * 내정보 수정
	 * @param eId
	 * @param eMobile
	 * @param Email
	 * @param eAddress
	 * @return 성공 1 실패 0
	 */
	public int updateInfo(String eId,String eMobile, String Email,String eAddress) {
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		String sql = "update employee set e_mobile=? , e_email=? , e_address=?  where e_id=?";
		
		try {
			conn = factory.getConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, eMobile);
			pstm.setString(2, Email);
			pstm.setString(3, eAddress);
			pstm.setString(4, eId);
			
			return pstm.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : 내정보 변경 오류");
		}
		finally {
			factory.close(conn, pstm);
		}
		return 0;
	}
	
	/**
	 * 사번중복조회
	 * @param eId
	 * @return
	 */
	public boolean checkId(String eId) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		//select * from employee where e_id=123456;
		String sql = "select * from employee where E_ID = ?";

		try {
			conn = factory.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, eId);
			rs = pstm.executeQuery();
			return rs.next();
				
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : 사번중복 조회 오류");
			
		}finally {
			factory.close(conn, pstm,rs);
		}
		return false;
	}
	/**
	 * 직원 계정 삭제
	 * @param eId
	 * @return
	 */
	public boolean delete(String eId) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;

		String sql = "delete from employee where e_id=?";

		try {
			conn = factory.getConnection();
	
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, eId);

			rs = pstm.executeQuery();
			return rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : 계정삭제 sql오류");

		} 
		factory.close(conn, pstm);
		return false;
	}
	
}