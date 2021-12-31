package com.nikon.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nikon.model.DBConn;
import com.nikon.model.nikonmemberVO;

public class nikonmemberDAO2 {
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
		
	public nikonmemberVO getnikonmember(nikonmemberVO vo) {
		nikonmemberVO nikonmember = null;	
		try {
	        System.out.println("DAO에서 받은 아아디"+vo.getMid()+", 비밀번호 : "+vo.getMpw());
			con = DBConn.getConnection();
			String	sql = "select * from nikonmember where mid=? and mpw=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getMid());
			stmt.setString(2, vo.getMpw());
			rs = stmt.executeQuery();
			nikonmember = new nikonmemberVO();			
			if(rs.next()) {
				nikonmember.setMid(rs.getString("mid"));
				nikonmember.setMpw(rs.getString("mpw"));
				nikonmember.setMname(rs.getString("mname"));
				nikonmember.setMtel(rs.getString("mtel"));
				nikonmember.setMemail(rs.getString("memail"));
				nikonmember.setMzipcode(rs.getString("mzipcode"));
				nikonmember.setMaddr1(rs.getString("maddr1"));
				nikonmember.setMaddr2(rs.getString("maddr2"));				
			} else {
				System.out.println("로그인 실패");
				nikonmember.setMid("guest");
			}
		} catch(Exception e) {
				e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, con);
		}
		return nikonmember;
	}
	
	public nikonmemberVO myPage(nikonmemberVO vo) {
		nikonmemberVO nikonmember = null;
		try {
			con = DBConn.getConnection();
			String sql = "select * from nikonmember where mid = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getMid());
			rs = stmt.executeQuery();
			if(rs.next()) {				
				nikonmember = new nikonmemberVO();
				nikonmember.setMid(rs.getString("mid"));
				nikonmember.setMpw(rs.getString("mpw"));
				nikonmember.setMname(rs.getString("mname"));
				nikonmember.setMtel(rs.getString("mtel"));		
				nikonmember.setMemail(rs.getString("memail"));
				nikonmember.setMzipcode(rs.getString("mzipcode"));
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
	
	public int updatenikonmember(nikonmemberVO vo) {
		int cnt = 0;
		try {
			con = DBConn.getConnection();
			String sql = "update nikonmember set mpw=?, mname=?, mtel=?, memail=?, mzipcode=?, maddr1=?, maddr2=? where mid=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getMpw());
			stmt.setString(2, vo.getMname());
			stmt.setString(3, vo.getMtel());
			stmt.setString(4, vo.getMtel());
			stmt.setString(5, vo.getMzipcode());
			stmt.setString(6, vo.getMaddr1());
			stmt.setString(7, vo.getMaddr2());
			stmt.setString(8, vo.getMid());
			cnt = stmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	
	public int deletenikonmember(nikonmemberVO vo) {	//탈퇴
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
	
	public int addnikonmember(nikonmemberVO vo) {	//회원가입
		int cnt = 0;
		try {
			con = DBConn.getConnection();
			String sql = "insert into nikonmember values(?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getMid());
			stmt.setString(2, vo.getMpw());
			stmt.setString(3,  vo.getMname());
			stmt.setString(4,  vo.getMtel());
			stmt.setString(5, vo.getMemail());
			stmt.setString(6, vo.getMzipcode());
			stmt.setString(7,  vo.getMaddr1());
			stmt.setString(8,  vo.getMaddr2());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	public int dupCheck(nikonmemberVO vo) {
		int cnt = 0;
		try {
			con = DBConn.getConnection();
			String sql = "select * from nikonmember where mid = ?";
			System.out.println("입력한 아이디 : "+vo.getMid());
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getMid());
			rs = stmt.executeQuery();
			if(rs.next()) {
				cnt = 1;		//사용이 불가능한 아이디
			} else {
				cnt = 0;		//사용이 가능한 아이디
			}
		} catch(Exception e) {
			System.out.println("데이터를 비교하지 못했습니다.");
			e.printStackTrace();
		}
		return cnt;
	}
}
