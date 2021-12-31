package com.nikon.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nikon.model.DBConn;
import com.nikon.model.nikonmemberVO;

public class nikonmemberDAO {
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public ArrayList<nikonmemberVO> getnikonmemberList() {
		ArrayList<nikonmemberVO> nikonmemberList = null;
		try {
			con = DBConn.getConnection();
			String sql = "select * from nikonmember";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			nikonmemberList = new ArrayList<nikonmemberVO>();
			while(rs.next()) {
				String mid = rs.getString("mid");
				String mpw = rs.getString("mpw");
				String mname = rs.getString("mname");
				String mtel = rs.getString("mtel");
				String memail = rs.getString("memail");
				String mzipcode = rs.getString("mzipcode");
				String maddr1 = rs.getString("maddr1");
				String maddr2 = rs.getString("maddr2");
				
				nikonmemberVO nikonmember = new nikonmemberVO();
				nikonmember.setMid(mid);
				nikonmember.setMpw(mpw);
				nikonmember.setMname(mname);
				nikonmember.setMtel(mtel);
				nikonmember.setMemail(memail);
				nikonmember.setMzipcode(mzipcode);
				nikonmember.setMaddr1(maddr1);
				nikonmember.setMaddr2(maddr2);				
				nikonmemberList.add(nikonmember);
				
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
		//VO의 값을 LIST에 담은 결과를 반환
		return nikonmemberList;
	}
	
	public nikonmemberVO getnikonmember(nikonmemberVO vo) {  //회원정보 가져오기
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
	

	public int addnikonmember(nikonmemberVO vo) {		//추가(회원가입)
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
	
	public int updatenikonmember(nikonmemberVO vo) {	//수정
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
	
	
	public int deletenikonmember(nikonmemberVO vo) {	//삭제
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
	
	
	 public nikonmemberVO login(nikonmemberVO vo) {//회원 로그인
		  nikonmemberVO nikonmember = null;
	      try {
	         con = DBConn.getConnection();
	         String sql = "select * from nikonmember where mid=? and mpw=?";
	         stmt = con.prepareStatement(sql);
	         stmt.setString(1, vo.getMid());
	         stmt.setString(2, vo.getMpw());
	         rs = stmt.executeQuery();
	         
	         if(rs.next()) {	            
				String mid = rs.getString("mid");
				String mpw = rs.getString("mpw");
				String mname = rs.getString("mname");
				String mtel = rs.getString("mtel");
				String memail = rs.getString("memail");
				String mzipcode = rs.getString("mzipcode");
				String maddr1 = rs.getString("maddr1");
				String maddr2 = rs.getString("maddr2");
				
				nikonmember = new nikonmemberVO();
				nikonmember.setMid(mid);
				nikonmember.setMpw(mpw);
				nikonmember.setMname(mname);
				nikonmember.setMtel(mtel);
				nikonmember.setMemail(memail);
				nikonmember.setMzipcode(mzipcode);
				nikonmember.setMaddr1(maddr1);
				nikonmember.setMaddr2(maddr2);				

	         }
	      }catch(Exception e){
	         e.printStackTrace();
	      } finally {
	         DBConn.close(rs, stmt, con);
	      }
	      return nikonmember;
	   }

	
	
	public int dupCheck(nikonmemberVO vo) { //아이디 중복체크
	      int cnt = 0;
	      try {
	         con = DBConn.getConnection();
	         String sql = "select * from nikonmember where mid=?";
	         stmt = con.prepareStatement(sql);
	         stmt.setString(1,vo.getMid());
	         rs = stmt.executeQuery();
	         if(rs!=null) {
	            cnt = 1;
	         }else{
	            cnt = 0;
	         }
	      }catch(Exception e) {
	      }
	      return cnt;
	   }

	
	  
}