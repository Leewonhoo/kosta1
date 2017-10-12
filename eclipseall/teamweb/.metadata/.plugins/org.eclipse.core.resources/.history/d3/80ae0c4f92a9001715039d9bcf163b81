package work.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import work.Dto.FlightDto;

public class FlightDao {
	private FactoryDao factory = FactoryDao.getinstance();
	private static FlightDao instance = new FlightDao();
	
	private FlightDao() { }
	
	public static FlightDao getInstance() {
		return instance;
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
				+ " F_GATE from flight where F_LEAVE=? AND F_ARRIVE=? AND F_LEVDATE > sysdate ORDER BY F_LEAVE";
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
				String gate = rs.getString("F_GATE");
				list.add(new FlightDto(fDate, fAnum, fName, leav, leaDate, arr, arrDate, gate));
			}
			return list;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(rs, pst, con);
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
			factory.close(rs, pst, con);
		}
		return false;
	}
	
}
