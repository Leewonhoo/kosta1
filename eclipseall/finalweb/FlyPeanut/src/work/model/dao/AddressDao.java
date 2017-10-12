package work.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import work.model.dto.AddressDto;

public class AddressDao {
	private FactoryDao factory = FactoryDao.getInstance();
	private static AddressDao instance = new AddressDao();
	
	private AddressDao() { }
	
	public static AddressDao getInstance() {
		return instance;
	}
	
	/**
	 * <pre>조회한 글의 개수</pre>
	 * @param roadname
	 * @return 1
	 */
	public int AllPost(String roadname) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT count(*)\"count\" FROM post WHERE P_ROAD=?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, roadname);
			rs = pst.executeQuery();
			while (rs.next()) {
				return rs.getInt("count");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(con, pst, rs);
		}
		return 0;
	}
	
	/**
	 * <pre>우편번호 조회</pre>
	 * @param roadname
	 * @return 1
	 */
	public HashMap<Integer, AddressDto> searchPost(String roadname) {
		HashMap<Integer, AddressDto> hash = new HashMap<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT P_POST, P_DO, P_GU, P_ROAD, P_RFIRST, P_RSECOND, P_BUILD, P_DONG,"
				+ "NVL(P_SUBDONG, \' \')\"P_SUBDONG\", P_DFIRST, P_DSECOND FROM post WHERE P_DONG=? ORDER BY P_POST";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, roadname);
			rs = pst.executeQuery();
			int count = 0;
			while (rs.next()) {
				String post = rs.getString("P_POST");
				String dosi = rs.getString("P_DO");
				String gu = rs.getString("P_GU");
				String road = rs.getString("P_ROAD");
				String rnum = rs.getString("P_RFIRST")+" - "+rs.getString("P_RSECOND");
				String build = rs.getString("P_BUILD");
				String dong = rs.getString("P_DONG");
				String subdong = rs.getString("P_SUBDONG");
				String dnum = rs.getString("P_DFIRST")+" - "+rs.getString("P_DSECOND");
				hash.put(count, new AddressDto(post, dosi, gu, road, dong, subdong, rnum, dnum, build));
				count++;
			}
			return hash;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(con, pst, rs);
		}
		return null;
	}
}
