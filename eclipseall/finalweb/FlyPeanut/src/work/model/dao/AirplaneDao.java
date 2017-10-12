package work.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import work.model.dto.AirplaneDto;
import work.model.dto.NoticeDto;

public class AirplaneDao {
	private FactoryDao factory = FactoryDao.getInstance();
	private static AirplaneDao instance = new AirplaneDao();
	private AirplaneDao() {}
	public static AirplaneDao getInstance() {
		return instance;
	}

	public int addAirplane(AirplaneDto adto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		String sql = "insert into airplane values(?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, adto.getaNum());
			pstmt.setString(2, adto.getaKind());
			pstmt.setString(3, adto.getaType());
			pstmt.setInt(4, adto.getaPax());
			pstmt.setString(5, adto.getaMdate());
			pstmt.setString(6, adto.getaMake());
			pstmt.setString(7, adto.getaState());
			pstmt.setInt(8, adto.getaFirstRow());
			pstmt.setString(9, adto.getaFirstCol());
			pstmt.setInt(10, adto.getaBusinessRow());
			pstmt.setString(11, adto.getaBusinessCol());
			pstmt.setInt(12, adto.getaEconomyRow());
			pstmt.setString(13, adto.getaEconomyCol());
			return pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}

	public ArrayList<AirplaneDto> selectTitle(AirplaneDto adto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from airplane";
		
		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<AirplaneDto> list = new ArrayList<>();
			while(rs.next()) {
				adto = new AirplaneDto();
				adto.setaNum(rs.getInt("a_num"));
				adto.setaKind(rs.getString("a_kind").toString());
				adto.setaType(rs.getString("a_type").toString());
				adto.setaPax(rs.getInt("a_pax"));
				adto.setaMdate(rs.getString("a_mdate").toString());
				adto.setaMake(rs.getString("a_make").toString());
				adto.setaState(rs.getString("a_state").toString());
				adto.setaFirstRow(rs.getInt("a_firrow"));
				adto.setaFirstCol(rs.getString("a_fircol").toString());
				adto.setaBusinessRow(rs.getInt("a_binrow"));
				adto.setaBusinessCol(rs.getString("a_bincol").toString());
				adto.setaEconomyRow(rs.getInt("a_ecorow"));
				adto.setaEconomyCol(rs.getString("a_ecocol").toString());
				list.add(adto);
			}
			return list;
			
		} catch(SQLException e) {
			
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}

	public AirplaneDto viewAirplane(int airNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AirplaneDto adto1 = new AirplaneDto();
		String sql = "select * from airplane where a_num = ?";
		
		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, airNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				adto1 = new AirplaneDto();
				adto1.setaNum(rs.getInt("a_num"));
				adto1.setaKind(rs.getString("a_kind").toString());
				adto1.setaType(rs.getString("a_type").toString());
				adto1.setaPax(rs.getInt("a_pax"));
				adto1.setaMdate(rs.getString("a_mdate").toString());
				adto1.setaMake(rs.getString("a_make").toString());
				adto1.setaState(rs.getString("a_state").toString());
				adto1.setaFirstRow(rs.getInt("a_firrow"));
				adto1.setaFirstCol(rs.getString("a_fircol").toString());
				adto1.setaBusinessRow(rs.getInt("a_binrow"));
				adto1.setaBusinessCol(rs.getString("a_bincol").toString());
				adto1.setaEconomyRow(rs.getInt("a_ecorow"));
				adto1.setaEconomyCol(rs.getString("a_ecocol").toString());
				
				System.out.println(adto1);
				return adto1;
			}			
			
		} catch(SQLException e) {
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}
}
