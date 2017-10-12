package work.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import work.model.dto.Bboard;
import work.model.dto.Bmember;

public class BboardDao {
	private FactoryDao factory = FactoryDao.getinstance();
	private static BboardDao instance = new BboardDao();

	private BboardDao() { }

	public static BboardDao getInstance() {
		return instance;
	}
	
	/**
	 * �Խñ� ��ȣ ã��
	 * @param num
	 * @return �Խñ� ��ȣ
	 */
	public boolean isB_num(int num) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT b_num FROM BBOARD WHERE B_NUM=?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, num);
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
	 * ������ �г��� Ȯ��
	 * </pre>
	 * @param nick
	 * @param num
	 * @return �г���
	 */
	public boolean isB_nick(String nick, int num) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT B_NICK FROM BBOARD WHERE B_NICK=? AND B_NUM=?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, nick);
			pst.setInt(2, num);
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
	 * �Խ��� �Է�
	 * </pre>
	 * @param DTO
	 * @return ���̺� �Է�
	 */
	public int insert(Bboard DTO) {
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "INSERT INTO BBOARD(B_ID, B_NICK, B_PW, B_TITLE, B_MEMO, B_TIME, B_TAG, B_NUM)"
				+ "VALUES (?,?,?,?,?,sysdate,?,bbor_seq.nextval)";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, DTO.getbId());
			pst.setString(2, DTO.getbNick());
			pst.setString(3, DTO.getbPw());
			pst.setString(4, DTO.getbTitle());
			pst.setString(5, DTO.getbMemo());
			pst.setString(6, DTO.getbTag());
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
	 * ȸ�� ���� ����� �Խ��� ����
	 * </pre>
	 * @param DTO
	 * @return �Խ��� �г��� ����
	 */
	public int bnickupdate(String id, String nick) {
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "UPDATE BBOARD SET b_nick=? WHERE b_id=?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, nick);
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
	 * <pre>
	 * �Խ��� ����
	 * </pre>
	 * @param nick
	 * @param pw
	 * @param num
	 * @return �Խ��� ����
	 */
	public int delete(String nick, String pw, int num) {
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "DELETE FROM BBOARD WHERE b_nick=? AND b_pw=? AND b_num=?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, nick);
			pst.setString(2, pw);
			pst.setInt(3, num);
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
	 * ���� ����
	 * </pre>
	 * @param id
	 * @param nick
	 * @return ȸ�� ����
	 */
	public ArrayList selectinfor(String id, String nick) {
		ArrayList al = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT m_id, m_pw, m_name, m_name, m_nick, to_char(m_birth,'yyyyMMdd')\"m_birth\","
				+ "m_phone, m_mail, m_gender, m_address, m_answer FROM BMEMBER WHERE m_id=? AND m_nick=?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, nick);
			rs = pst.executeQuery();
			while (rs.next()) {
				String sid = rs.getString("m_id");
				String spw = rs.getString("m_pw");
				String sname = rs.getString("m_name");
				String snick = rs.getString("m_nick");
				String sbirth = rs.getString("m_birth");
				String sphone = rs.getString("m_phone");
				String smail = rs.getString("m_mail");
				String sgender = rs.getString("m_gender");
				String saddress = rs.getString("m_address");				
				String sanswer = rs.getString("m_answer");
				if (sphone == null) {
					sphone = "";
				}
				if (smail == null) {
					smail = "";
				}
				if (saddress == null) {
					saddress = "";
				}
				al.add(new Bmember(sid, spw, sname, snick, sbirth, sphone, smail, sgender, saddress, sanswer));
			}
			return al;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(rs, pst, con);
		}
		return null;
	}
	
	/**
	 * <pre>
	 * �湮�� ��Ƚ�� ����
	 * </pre>
	 * @param DTO
	 * @return ���� 1, ���� 0
	 */
	public int bborupdate(int num) {   //�Խ��� �湮��  ��Ƚ�� ����
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pst1 = null;
		ResultSet rs = null;
		String sql = "SELECT b_visit FROM bboard WHERE b_num=?";
		String sql1 = "UPDATE bboard SET b_visit=? WHERE b_num=?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, num);
			rs = pst.executeQuery();
			rs.next();
			int count = rs.getInt("b_visit")+1;
			pst1 = con.prepareStatement(sql1);
			pst1.setInt(1, count);
			pst1.setInt(2, num);
			return pst1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(pst, con);
		}
		return 0;
	}
	
	/**
	 * <pre>
	 * ȸ�� ���� ����� �г��� Ȯ��
	 * </pre>
	 * @param nick
	 * @return ���̵�
	 */
	public String isM_nick(String nick) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT M_ID FROM BMEMBER WHERE M_NICK=?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, nick);
			rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getString("m_id");
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(rs, pst, con);
		}
		return null;
	}
	
	/**
	 * <pre>
	 * ȸ������ ������Ʈ
	 * </pre>
	 * @param DTO
	 * @return ���� : 1 , ���� : 0
	 */
	public int bmemupdate(Bmember DTO) {   //ȸ�� ����
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "UPDATE BMEMBER SET m_pw=?, m_nick=?, m_birth=?, m_phone=?, m_mail=?,"
				+ "m_gender=?, m_address=?, m_answer=? WHERE m_id=?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, DTO.getmPw());
			pst.setString(2, DTO.getmNick());
			pst.setString(3, DTO.getmBirth());
			pst.setString(4, DTO.getmPhone());
			pst.setString(5, DTO.getmMail());
			pst.setString(6, DTO.getmGender());
			pst.setString(7, DTO.getmAddress());
			pst.setString(8, DTO.getmAnswer());
			pst.setString(9, DTO.getmId());
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
	 * all list
	 * </pre>
	 * @param num  //목록 갯수
	 * @return �Խ��� ����
	 */
	public ArrayList selectAll(int num, int page) {
		ArrayList al = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql1 = "(SELECT * FROM BBOARD ORDER BY b_num DESC)";
		String sql = "SELECT rownum, b_nick, b_num, b_title, to_char(b_time,'yyyy.MM.dd')\"b_time\", b_visit "
				+ "FROM "+sql1+" WHERE rownum <= ?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, (num*page));
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
					String all = brownum+":"+bnum+":"+btitle+":"+bnick+":"+btime+":"+bvisit;
					//al.add(new Bboard(bnick, bnum, btitle, btime, bvisit));
					al.add(all);
				}
			}
			return al;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(rs, pst, con);
		}
		return null;
	}
	
	/**
	 * <pre>
	 * my list
	 * </pre>
	 * @param num
	 * @param nick
	 * @return �ۼ��� �Խñ�
	 */
	public ArrayList selectmy(int num, String nick) {
		ArrayList al = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql1 = "(SELECT * FROM BBOARD WHERE b_nick=? ORDER BY b_num DESC)";
		String sql = "SELECT rownum, b_nick, b_num, b_title, to_char(b_time,'yyyy.MM.dd')\"b_time\", b_visit "
				+ "FROM "+sql1+" WHERE rownum <= ?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, nick);
			pst.setInt(2, (num*5));
			rs = pst.executeQuery();
			while (rs.next()) {
				int a = rs.getInt("rownum");
				if ((a>(num-1)*5) && (a<=(num*5))){
					String bnick = rs.getString("b_nick");
					int bnum = rs.getInt("b_num");
					String btitle = rs.getString("b_title");
					String btime = rs.getString("b_time");
					int bvisit = rs.getInt("b_visit");
					al.add(new Bboard(bnick, bnum, btitle, btime, bvisit));
				}
			}
			return al;
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
		String sql = "SELECT count(*)count FROM BBOARD ORDER BY b_num DESC";
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
	
	/**
	 * <pre>
	 * �Խñ� ���� ����
	 * </pre>
	 * @param num
	 * @return �Խñ� ���� ����
	 */
	public ArrayList bdeatil(int num) {
		ArrayList al = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT b_nick, b_title, b_memo, to_char(b_time,'yyyy.MM.dd')\"b_time\", b_visit, b_tag FROM bboard WHERE b_num=?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, num);
			rs = pst.executeQuery();
			rs.next();
			//if (rs.next()) {
				al.add(rs.getString("b_nick"));
				al.add(rs.getString("b_title"));
				al.add(rs.getString("b_memo"));
				al.add(rs.getString("b_time"));
				al.add(rs.getString("b_visit"));
				al.add(rs.getString("b_tag"));
			//}
			return al;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close(rs, pst, con);
		}
		return null;
	}

}
