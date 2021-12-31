package com.nikon.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nikon.model.DBConn;
import com.nikon.model.nikonboxVO;
import com.nikon.model.nikonmemberVO;

public class nikonboxDAO {
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public ArrayList<nikonboxVO> getnikonboxList() {
		ArrayList<nikonboxVO> nikonboxList = null;
		try {
			con = DBConn.getConnection();
			String sql = "select * from nikonbox";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			nikonboxList = new ArrayList<nikonboxVO>();
			while(rs.next()) {
				int bno = rs.getInt("bno");
				String bcom = rs.getString("bcom");
				String baddr = rs.getString("baddr");			
				String btel = rs.getString("btel");
				
				nikonboxVO nikonbox = new nikonboxVO();
				nikonbox.setBno(bno);
				nikonbox.setBcom(bcom);
				nikonbox.setBaddr(baddr);
				nikonbox.setBtel(btel);
				nikonboxList.add(nikonbox);		
			}
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 되지 않았습니다.");
			e.printStackTrace();
		}  catch(SQLException e) {
			System.out.println("SQL 구문 또는 열이름, 변수명 등이 서로 맞지 않습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, con);
		}
		return nikonboxList;
	}
	
	public nikonboxVO getnikobox(nikonboxVO vo) {  
		nikonboxVO nikonbox = null;
		try {
			con = DBConn.getConnection();
				String sql = "select * from nikonbox where bno = ?";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, vo.getBno());
				rs = stmt.executeQuery();
				if(rs.next()) {
					nikonbox = new nikonboxVO();
					nikonbox.setBno(rs.getInt("bno"));
					nikonbox.setBcom(rs.getString("bcom"));
					nikonbox.setBaddr(rs.getString("baddr"));
					nikonbox.setBtel(rs.getString("btel"));
				}	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, con);
		}
		return nikonbox;
	}
	

	public int addnikonbox(nikonboxVO vo) {		
		int cnt = 0;
		try {
			con = DBConn.getConnection();
			String sql = "insert into nikonbox values(?, ?, ?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, vo.getBno());
			stmt.setString(2, vo.getBcom());
			stmt.setString(3,  vo.getBaddr());
			stmt.setString(4,  vo.getBtel());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	
	public int updatenikonbox(nikonboxVO vo) {	//수정
		int cnt = 0;
		try {
			con = DBConn.getConnection();
			String sql = "update nikonbox set bcom=?, baddr=?, btel=? where bno=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "bcom");
			stmt.setString(2, "baddr");
			stmt.setString(3, "btel");
			stmt.setString(4, "bno");

			cnt = stmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	
	
	public int deletenikonbox(nikonboxVO vo) {	//삭제
		int cnt=0;
		try {
			con = DBConn.getConnection();
			String sql = "delete from nikonbox where bno=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, vo.getBno());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	
}
