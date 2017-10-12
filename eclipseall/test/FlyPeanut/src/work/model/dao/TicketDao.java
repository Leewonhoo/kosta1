package work.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import work.model.dto.EmployeeDto;
import work.model.dto.ReservationDto;
import work.util.Utility;

public class TicketDao {
	
	private FactoryDao factory = FactoryDao.getInstance();
	private static TicketDao instance = new TicketDao();

	private TicketDao() {}
	
	public static TicketDao getInstance() {
		return instance;
	}
	/**
	 * 발행 전 승객 조회
	 * @param cName
	 * @param rNum
	 * @return 
	 */
	public String issueSearch(String rName, String rNum) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		
		String sql = "select * from RESERVATION  where r_name=? and r_num=?";

		try {
			conn = factory.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, rName);
			pstm.setString(2, rNum);
			rs = pstm.executeQuery();

			if(rs.next()) {
				return rName;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : 승객조회 오류");
		} finally {
			factory.close(conn, pstm);
		}
		return null;
	}
	/**
	 * 수하물 추가
	 * @param rName
	 * @param tBagNum
	 * @return
	 */
	public String setBagg(String rName,String tBagNum) {
		Connection conn = null;
		PreparedStatement pstm = null;
		
		String sql = "update ticket set t_bagnum=? where t_name=? ";
		
		try {
			conn = factory.getConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, tBagNum);
			pstm.setString(2, rName);
			
			if(pstm.executeUpdate()==1) {
				return tBagNum;  				
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
	 * 예약한 승객 조회
	 * @param rName
	 * @param rNum
	 * @return
	 */
	public ReservationDto searchReservation(String rName, String rNum) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		
		//select * from reservation where r_name='fff' and r_num='fff';
		String sql = "select r_num , r_name , r_departure ,r_departuretime,r_arrival,r_arrivaltime, r_seat ,r_anum, to_char(r_date, 'yyyy. mm. dd.') \"r_date\" , r_fname , r_class from reservation where r_name=? and r_num=?";

		try {
			conn = factory.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, rName);
			pstm.setString(2, rNum);
			rs = pstm.executeQuery();
			if (rs.next()) {
				String rDeparture = rs.getString("r_departure");
				String rDepartureTime = rs.getString("r_departuretime");
				String rArrival = rs.getString("r_arrival");
				String rArrivalTime = rs.getString("r_arrivaltime");
				String rSeat = rs.getString("r_seat");
				String rAnum = rs.getString("r_anum");
				String rDate = rs.getString("r_date");
				String rFname = rs.getString("r_fname");
				String rClass = rs.getString("r_class");
				
				return new ReservationDto(rNum,rName,rDeparture,rDepartureTime,rArrival,rArrivalTime,rSeat,rAnum,rDate,rFname,rClass);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error : 승객 조회 오류");
		}finally {
			factory.close(conn, pstm,rs);
		}
		return null;
	}
	
	
}
