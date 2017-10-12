package work.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import work.model.dto.AirplaneDto;
import work.model.dto.FlightDto;
import work.model.dto.NoticeDto;

public class FlightDao {

private FactoryDao factory = FactoryDao.getInstance();
	
	private static FlightDao instance = new FlightDao();
	
	private FlightDao() {}
	
	public static FlightDao getInstance() {
		return instance;
	}

	
	/**
	 * <pre>
	 * 운항정보 조회
	 * </pre>
	 * 
	 * @param leave
	 * @param arrive
	 * @return
	 */
	public ArrayList<FlightDto> FlightSelect(String leave, String arrive) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		String sql = "select to_char(f_date, 'yyyy.mm.dd') \"date\", f_anum, f_fname, f_leave, to_char(f_levdate, 'yyyy.mm.dd hh24:mi') \"leave\", f_arrive, to_char(f_arridate, 'yyyy.mm.dd hh24:mi') \"arrive\", f_gate from flight where F_LEAVE = ? and F_ARRIVE = ?";
		
		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, leave);
			pstmt.setString(2, arrive);
			rs = pstmt.executeQuery();
			
			
			ArrayList<FlightDto> list = new ArrayList<>();
			while(rs.next()) {
				FlightDto fdto = new FlightDto();
				fdto.setfDate(rs.getString("date"));
				fdto.setfANum(rs.getInt("f_anum"));
				fdto.setfFName(rs.getString("f_fname"));
				fdto.setfLeave(rs.getString("f_leave"));
				fdto.setfLeaveDate(rs.getString("leave"));
				fdto.setfArrive(rs.getString("f_arrive"));
				fdto.setfArriveDate(rs.getString("arrive"));
				fdto.setfGate(rs.getInt("f_gate"));

				list.add(fdto);
			}
		
			return list;
			
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("전체 운항정보 조회 실패");
			
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}

	
	/**
	 * <pre>
	 * 운항정보 등록
	 * </pre>
	 * 
	 * @param fdto
	 * @return
	 */
	public int FlightWrite(FlightDto fdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		String sql = "insert into flight values(to_date(?,'yyyy.mm.dd'), ?, ?, ?, to_date(?,'yyyy.mm.dd hh24:mi'), ? ,to_date(?,'yyyy.mm.dd hh24:mi'), ?);";
		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, fdto.getfDate());
			pstmt.setInt(2, fdto.getfANum());
			pstmt.setString(3, fdto.getfFName());
			pstmt.setString(4, fdto.getfLeave());
			pstmt.setString(5, fdto.getfLeaveDate());
			pstmt.setString(6, fdto.getfArrive());
			pstmt.setString(7, fdto.getfArriveDate());
			pstmt.setInt(8, fdto.getfGate());
			
			return pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("운항정보 등록 실패!");
		} finally {
			factory.close(conn, pstmt);
		}
		
		return 0;
	}
	
	/**
	 * <pre>
	 * 운항정보 수정시 전체 띄우기
	 * </pre>
	 * 
	 * @param fdto1
	 * @return
	 */
	public ArrayList<FlightDto> FlightAll(FlightDto fdto1) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select to_char(f_date, 'yyyy.mm.dd') \"date\", f_anum, f_fname, f_leave, to_char(f_levdate, 'yyyy.mm.dd hh24:mi') \"leave\", f_arrive, to_char(f_arridate, 'yyyy.mm.dd hh24:mi') \"arrive\", f_gate from flight";
		
		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<FlightDto> list2 = new ArrayList<>();
			while(rs.next()) {
				fdto1 = new FlightDto();
				fdto1.setfDate(rs.getString("date"));
				fdto1.setfANum(rs.getInt("f_anum"));
				fdto1.setfFName(rs.getString("f_fname"));
				fdto1.setfLeave(rs.getString("f_leave"));
				fdto1.setfLeaveDate(rs.getString("leave"));
				fdto1.setfArrive(rs.getString("f_arrive"));
				fdto1.setfArriveDate(rs.getString("arrive"));
				fdto1.setfGate(rs.getInt("f_gate"));
				

				list2.add(fdto1);
			}
		
			return list2;
			
			
		} catch(SQLException e) {
			System.out.println("운항 정보 전체 조회 실패");
			
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}

	/**
	 * <pre>
	 * 운항정보 수정시 한 행 정보 띄우기
	 * </pre>
	 * 
	 * @param upNum
	 * @return
	 */
	public FlightDto FlightUpView(int upNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select to_char(f_date, 'yyyy.mm.dd') \"date\", f_anum, f_fname, f_leave, to_char(f_levdate, 'yyyy.mm.dd hh24:mi') \"leave\", f_arrive, to_char(f_arridate, 'yyyy.mm.dd hh24:mi') \"arrive\", f_gate from flight where f_anum = ?";
		FlightDto fdto2 = new FlightDto();
		
		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, upNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				fdto2 = new FlightDto();
				fdto2.setfDate(rs.getString("date"));
				fdto2.setfANum(rs.getInt("f_anum"));
				fdto2.setfFName(rs.getString("f_fname"));
				fdto2.setfLeave(rs.getString("f_leave"));
				fdto2.setfLeaveDate(rs.getString("leave"));
				fdto2.setfArrive(rs.getString("f_arrive"));
				fdto2.setfArriveDate(rs.getString("arrive"));
				fdto2.setfGate(rs.getInt("f_gate"));
				
			}
		
			return fdto2;
			
			
		} catch(SQLException e) {
			System.out.println("운항정보 선택 조회 실패");
			
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}

	
	/**
	 * <pre>
	 * 운항정보 수정
	 * </pre>
	 * 
	 * @param fdto3
	 * @return
	 */
	public int FlightUpdate(FlightDto fdto3) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update flight set f_fname = ?,  f_leave = ?, f_arrive = ?, f_gate = ?  where f_anum = ? ";
		
		
		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fdto3.getfFName());
			pstmt.setString(2, fdto3.getfLeave());
			pstmt.setString(3, fdto3.getfArrive());
			pstmt.setInt(4, fdto3.getfGate());
			pstmt.setInt(5, fdto3.getfANum());

			return pstmt.executeUpdate();
			
		
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("운항정보 수정 실패");
			
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}
	
	 /**
	    * <pre>운항일지 조회</pre>
	    * @return
	    */
	   public ArrayList<FlightDto> selectFlight(String flight, String arrive){
	      ArrayList<FlightDto> list = new ArrayList<>();
	      Connection con = null;
	      PreparedStatement pst = null;
	      ResultSet rs = null;
	      String sql = "select to_char(F_DATE, 'yyyy. mm. dd.')\"F_DATE\", F_ANUM, F_FNAME, F_LEAVE,"
	            + "to_char(F_LEVDATE, 'yyyy. mm. dd. HH24:MI')\"F_LEVDATE\", F_ARRIVE, to_char(F_ARRIDATE, 'yyyy. mm. dd. HH24:MI')\"F_ARRIDATE\","
	            + " F_GATE from flight where F_LEAVE = ? AND F_ARRIVE = ? AND F_LEVDATE > sysdate ORDER BY F_LEAVE";
	      try {
	         con = factory.getConnection();
	         pst = con.prepareStatement(sql);
	         pst.setString(1, flight);
	         pst.setString(2, arrive);
	         rs = pst.executeQuery();
	         while (rs.next()) {
	            String fDate = rs.getString("F_DATE");
	            int fAnum = rs.getInt("F_ANUM");
	            String fName = rs.getString("F_FNAME");
	            String leav = rs.getString("F_LEAVE");
	            String leaDate = rs.getString("F_LEVDATE");
	            String arr = rs.getString("F_ARRIVE");
	            String arrDate = rs.getString("F_ARRIDATE");
	            int gate = rs.getInt("F_GATE");
	            list.add(new FlightDto(fDate, fAnum, fName, leav, leaDate, arr, arrDate, gate));
	         }
	         return list;
	      } catch(Exception e) {
	         e.printStackTrace();
	      } finally {
	         factory.close(con, pst, rs);
	      }
	      return null;
	   }
	   
	   /**
	    * <pre>예약번호 중복 조회</pre>
	    * @param number
	    * @return
	    */
	   public boolean is_rNum(int number) {
	      Connection con = null;
	      PreparedStatement pst = null;
	      ResultSet rs = null;
	      String sql = "SELECT R_NUM FROM RESERVATION WHERE R_NUM=?";
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

}
