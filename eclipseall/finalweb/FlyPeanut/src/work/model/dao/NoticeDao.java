package work.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import work.model.dto.NoticeDto;

public class NoticeDao {
	
	private FactoryDao factory = FactoryDao.getInstance();
	private static NoticeDao instance = new NoticeDao();
	private NoticeDao() {}

	public static NoticeDao getInstance() {
		return instance;
	}

	/**
	 * <pre>
	 * 공지사항 전체 출력
	 * </pre>
	 * @param ndto
	 * @return list
	 */
	public ArrayList<NoticeDto> selectAll(NoticeDto ndto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ndto = new NoticeDto();
		String sql = "select n_num,n_title,n_contents,to_char(n_date, 'yyyy.mm.dd') \"date\" from notice order by n_num desc";
		
		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<NoticeDto> list = new ArrayList<>();
			while(rs.next()) {
				ndto = new NoticeDto();
				ndto.setnNum(rs.getInt("n_num"));
				ndto.setnTitle(rs.getString("n_title").toString());
				ndto.setnContents(rs.getString("n_contents").toString());
				ndto.setnDate(rs.getString("date").toString());

				list.add(ndto);
			}
		
			return list;
			
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("공지사항 조회 실패");
			
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}

	/**
	 * <pre>
	 * 공지사항 상세보기
	 * </pre>
	 * @param noticeNum
	 * @return
	 */
	public NoticeDto noticeView(int noticeNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		String sql = "select n_num, n_title, n_contents, to_char(n_date, 'yyyy.mm.dd') \"date\" from notice where n_num = ?";
		
		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				NoticeDto ndto = new NoticeDto();
				ndto.setnNum(rs.getInt("n_num"));
				ndto.setnTitle(rs.getString("n_title").toString());
				ndto.setnContents(rs.getString("n_contents").toString());
				ndto.setnDate(rs.getString("date").toString());
				
				return ndto;
			}			
			
			
		} catch(SQLException e) {
			System.out.println("공지사항 한행 조회 실패");
			
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}

	/**
	 * <pre>
	 * 공지사항 등록
	 * </pre>
	 * @param title
	 * @param contents
	 * @return
	 */
	public int writeNotice(String title, String contents) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		String sql = "insert into notice values(notice_seq.nextval,?,?, to_char(sysdate, 'yyyy.mm.dd')) ";
		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, contents);

			
			return pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("공지사항 등록 실패");
		} finally {
			factory.close(conn, pstmt);
		}
		
		return 0;
	}

}
