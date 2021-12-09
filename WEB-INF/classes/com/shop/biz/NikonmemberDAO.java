package com.shop.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.model.DBConn;
import com.shop.model.NikonmemberVO;

public class NikonmemberDAO {
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public ArrayList<NikonmemberVO> getNikonmember() {
		ArrayList<NikonmemberVO> nikonmemberList = null;
		try {
			con = DBConn.getConnection();
			String sql = "select * from nikonmember order by mid";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			nikonmemberList = new ArrayList<NikonmemberVO>();
			while(rs.next()) {
				String mid = rs.getString("mid");
				String mpw = rs.getString("mpw");
				String mname = rs.getString("mname");
				String mtel = rs.getString("mtel");
				String maddr1 = rs.getString("maddr1");
				String maddr2 = rs.getString("maddr2");
				
				NikonmemberVO nikonmember = new NikonmemberVO();
				nikonmember.setMid(mid);
				nikonmember.setMpw(mpw);
				nikonmember.setMname(mname);
				nikonmember.setMtel(mtel);
				nikonmember.setMaddr1(maddr1);
				nikonmember.setMaddr2(maddr2);
				
				nikonmemberList.add(nikonmember);
			}
		}	catch(ClassNotFoundException e) {
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
		
		return nikonmemberList;
			
	}
	
	public NikonmemberVO getNikonmember(NikonmemberVO vo) {
		NikonmemberVO nikonmember = null;
		try {
			con = DBConn.getConnection();
			String sql = "select * from nikonmember where mid = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getMid());
			rs = stmt.executeQuery();
			if(rs.next()) {
				nikonmember = new NikonmemberVO();
				nikonmember.setMid(rs.getString("mid"));
				nikonmember.setMpw(rs.getString("mpw"));
				nikonmember.setMname(rs.getString("mname"));
				nikonmember.setMtel(rs.getString("mtel"));
				nikonmember.setMaddr1(rs.getString("maddr1"));
				nikonmember.setMaddr2(rs.getString("maddr2"));
			}	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, con);
		}
		return nikonmember;	
	}	
	public int updateNikonmember(NikonmemberVO vo) {
		int cnt = 0;
		try {
			con = DBConn.getConnection();
			String sql = "update nikonmember set mname=?, mtel=?, maddr1=?, maddr2=? where mid=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getMname());
			stmt.setString(2, vo.getMtel());
			stmt.setString(3, vo.getMaddr1());
			stmt.setString(4, vo.getMaddr2());
			stmt.setString(5, vo.getMid());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	public int deleteNikonmember(NikonmemberVO vo) {
		int cnt=0;
		try {
			con = DBConn.getConnection();	
			String sql = "delete from nikonmember where mid=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getMid());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	public int addNikonmember(NikonmemberVO vo) {
		int cnt = 0;
		try {
			con = DBConn.getConnection();
			String sql = "insert into nikonmember values (?,?,?,?,?,?)";
			stmt.setString(1, vo.getMid());
			stmt.setString(2, vo.getMpw());
			stmt.setString(3, vo.getMname());
			stmt.setString(4, vo.getMtel());
			stmt.setString(5, vo.getMaddr1());
			stmt.setString(6, vo.getMaddr2());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
}
			