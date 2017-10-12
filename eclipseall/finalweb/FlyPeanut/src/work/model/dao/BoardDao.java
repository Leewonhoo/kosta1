package work.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import work.model.dto.BoardDto;
import work.model.dto.ReplyDto;

public class BoardDao {
	private FactoryDao factory = FactoryDao.getInstance();
	private static BoardDao instance = new BoardDao();
	
	private BoardDao() { }
	
	public static BoardDao getInstance() {
		return instance;
	}
	
	/**
	 * <pre>게시글 등록</pre>
	 * @param DTO
	 * @return 1
	 */
	public int insert(BoardDto DTO) {
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "INSERT INTO BOARD VALUES (borad_seq.nextval,?,?,?,sysdate,?)";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, DTO.getbTitle());
			pst.setString(2, DTO.getbContext());
			pst.setString(3, DTO.getbWriter());
			pst.setString(4, "N");
			return pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(con, pst);
		}
		return 0;
	}
	
	/**
	 * <pre>게시글 업데이트</pre>
	 * @param DTO
	 * @return 1
	 */
	public int update(BoardDto DTO) {
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "UPDATE BOARD SET B_TITLE=?, B_CONTENTS=?, B_DATE=sysdate WHERE B_NUM=?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, DTO.getbTitle());
			pst.setString(2, DTO.getbContext());
			pst.setInt(3, DTO.getbNum());
			return pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(con, pst);
		}
		return 0;
	}
	
	/**
	 * <pre>내가 쓴 글 갯수</pre>
	 * @param id
	 * @return 숫자
	 */
	public double myCount(String id) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT count(*)\"count\" ");
		sb.append("FROM board ");
		sb.append("WHERE B_ID=");
		sb.append("'"+id+"'");
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sb.toString());
			rs = pst.executeQuery();
			while (rs.next()) {
				int row = rs.getInt("count");
				return row;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(con, pst, rs);
		}
		return 0;
	}
	
	/**
	 * <pre>전체 작성글 확인</pre>
	 * @param id
	 * @return
	 */
	public HashMap<Integer, BoardDto> myList(String id){
		HashMap<Integer, BoardDto> hash = new HashMap<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT rownum, B_NUM, B_TITLE, B_CONTENTS, B_ID, to_char(B_DATE, 'yyyy. mm. dd.')\"B_DATE\", B_CHECK ");
		sb.append("FROM (SELECT * FROM board ORDER BY b_date DESC) ");
		sb.append("WHERE B_ID=");
		sb.append("'"+id+"'");
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sb.toString());
			rs = pst.executeQuery();
			while (rs.next()) {
				int row = rs.getInt("rownum");
				int num = rs.getInt("B_NUM");
				String title = rs.getString("B_TITLE");
				String content = rs.getString("B_CONTENTS");
				String writer = rs.getString("B_ID");
				String date = rs.getString("B_DATE");
				String check = rs.getString("B_CHECK");
				hash.put(row, new BoardDto(num, title, content, writer, date, check));
			}
			return hash;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(con, pst, rs);
		}
		return null;
	}
	
	/**
	 * <pre>상세 글 확인</pre>
	 * @param number
	 * @return
	 */
	public BoardDto detail(int number){
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT B_NUM, B_TITLE, B_CONTENTS, B_ID, to_char(B_DATE, 'yyyy. mm. dd.')\"B_DATE\", B_CHECK ");
		sb.append("FROM board ");
		sb.append("WHERE B_NUM=");
		sb.append(number);
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sb.toString());
			rs = pst.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("B_NUM");
				String title = rs.getString("B_TITLE");
				String content = rs.getString("B_CONTENTS");
				String writer = rs.getString("B_ID");
				String date = rs.getString("B_DATE");
				String check = rs.getString("B_CHECK");
				return new BoardDto(num, title, content, writer, date, check);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(con, pst, rs);
		}
		return null;
	}
	
	/**
	 * <pre>게시글 유무 확인</pre>
	 * @param number
	 * @return
	 */
	public boolean isbNum(int number) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT B_NUM FROM board WHERE B_NUM=?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, number);
			rs = pst.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(con, pst, rs);
		}
		return false;
	}
	
	/**
	 * <pre>답글 유무 확인</pre>
	 * @param number
	 * @return
	 */
	public boolean isrNum(int number) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT REP_NUM FROM reply WHERE REP_NUM=?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, number);
			rs = pst.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(con, pst, rs);
		}
		return false;
	}
	
	/**
	 * <pre>답글 호출</pre>
	 * @param number
	 * @return
	 */
	public ReplyDto reply(int number){
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT REP_NUM, REP_CONTENTS, to_char(REP_DATE, 'yyyy. mm. dd.')\"REP_DATE\" ");
		sb.append("FROM reply ");
		sb.append("WHERE REP_NUM=");
		sb.append(number);
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sb.toString());
			rs = pst.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("REP_NUM");
				String title = rs.getString("REP_CONTENTS");
				String content = rs.getString("REP_DATE");
				return new ReplyDto(num, title, content);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(con, pst, rs);
		}
		return null;
	}
	
	/**
	 * <pre>게시글 삭제</pre>
	 * @return
	 */
	public int delete(int number) {
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "DELETE FROM board WHERE B_NUM=?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, number);
			return pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(con, pst);
		}
		return 0;
	}
	
}
