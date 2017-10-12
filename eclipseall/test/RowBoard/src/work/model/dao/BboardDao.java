package work.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import work.model.dto.Bboard;

public class BboardDao {
	private FactoryDao factory = FactoryDao.getinstance();
	private static BboardDao instance = new BboardDao();

	private BboardDao() { }

	public static BboardDao getInstance() {
		return instance;
	}

	/**
	 * <pre>
	 * HashMap is board all list select
	 * </pre>
	 * @param num  //목록 갯수
	 * @return all list
	 */
	public HashMap<Integer, Bboard> selectAll(int num, int page) {
		HashMap<Integer, Bboard> hash = new HashMap<>(); 
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql1 = "(SELECT * FROM BBOARD ORDER BY b_num DESC)";
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT rownum, b_nick, b_num, b_title, to_char(b_time,'yyyy.MM.dd')\"b_time\", b_visit ");
		sql.append("FROM ");
		sql.append(sql1);
		sql.append(" WHERE rownum <= ");
		sql.append(num*page);
		
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql.toString());
			rs = pst.executeQuery();
			while (rs.next()) {
				int a = rs.getInt("rownum");
				if ((a>(page-1)*num) && (a<=(num*page))){
					int brownum = rs.getInt("rownum");
					String bnick = rs.getString("b_nick");
					int bnum = rs.getInt("b_num");
					String btitle = rs.getString("b_title");
					String btime = rs.getString("b_time");
					int bvisit = rs.getInt("b_visit");
					hash.put(brownum, new Bboard(bnick, bnum, btitle, btime, bvisit));
				}
			}
			return hash;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(rs, pst, con);
		}
		return null;
	}
	
	/**
	 * <pre>
	 * last list num
	 * </pre>
	 * @return �� ��ȣ
	 */
	public int selectLast() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT count(*)count FROM BBOARD";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			rs.next();
			return rs.getInt("count");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(rs, pst, con);
		}
		return 0;
	}
}
