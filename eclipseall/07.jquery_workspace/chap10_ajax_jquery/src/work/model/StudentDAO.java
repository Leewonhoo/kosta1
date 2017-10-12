package work.model;

import java.sql.*;
import java.util.*;

public class StudentDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String user = "scott";
	private String password = "tiger";

	public StudentDAO() {
		try {
			Class.forName(driver);
		} catch (Exception e ) { e.printStackTrace();   } 
	}

	// select name from student where name like '%J%';
	public String[] search(String name){
		Connection con = null;
		PreparedStatement pstmt=null;
		ArrayList<String> list = new ArrayList<String>();
		try {
			con = DriverManager.getConnection(url, user, password);
			String query = "SELECT name from student where name like ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%" + name + "%");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally { 
			try { 
				if(pstmt != null)pstmt.close();
				if(con != null)con.close();
			}catch(SQLException e){
					e.printStackTrace();
			}
		}
		return (String[])list.toArray(); 
	}

	// SELECT roll, name, marks from student
	public ArrayList<Student> search(){
		Connection con = null;
		PreparedStatement pstmt=null;
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			con = DriverManager.getConnection(url, user, password);
			String query = "SELECT roll, name, marks from student";
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Student(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally { 
			try { 
				if(pstmt != null)pstmt.close();
				if(con != null)con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list; 
	}

}