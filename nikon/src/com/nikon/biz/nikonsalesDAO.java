package com.nikon.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nikon.model.DBConn;
import com.nikon.model.nikonmemberVO;
import com.nikon.model.nikonsalesVO;

public class nikonsalesDAO {
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public ArrayList<nikonsalesVO> getnikonsalesList() {
		ArrayList<nikonsalesVO> nikonsalesList = null;
		try {
			con = DBConn.getConnection();
			String sql = "select * from nikonsales";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			nikonsalesList = new ArrayList<nikonsalesVO>();
			while(rs.next()) {
				String scode = rs.getString("scode");
				String sid = rs.getString("sid");
				int sprice = rs.getInt("sprice");
				String splace = rs.getString("splace");
				String srecieve = rs.getString("srecieve");
				nikonsalesVO nikonsales = new nikonsalesVO();
				
				nikonsales.setScode(scode);
				nikonsales.setSid(sid);
				nikonsales.setSprice(sprice);
				nikonsales.setSplace(splace);
				nikonsales.setSrecieve(srecieve);			
				nikonsalesList.add(nikonsales);
				
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
		return nikonsalesList;
	}
	
	public nikonsalesVO getnikonsales(nikonsalesVO vo) {  //회원정보 가져오기
		nikonsalesVO nikonsales = null;
		try {
			con = DBConn.getConnection();
				String sql = "select * from nikonsales where scode = ?";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, vo.getScode());
				rs = stmt.executeQuery();
				if(rs.next()) {
					nikonsales = new nikonsalesVO();
					nikonsales.setScode(rs.getString("scode"));

				}	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, con);
		}
		return nikonsales;
	}
	

	public int addnikonsales(nikonsalesVO vo) {		
		int cnt = 0;
		try {
			con = DBConn.getConnection();
			String sql = "insert into nikonsales values(?, ?, ?, ?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getScode());
			stmt.setString(2, vo.getSid());
			stmt.setInt(3, vo.getSprice());
			stmt.setString(4,  vo.getSplace());
			stmt.setString(5, vo.getSrecieve());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	
	public int updatenikonsales(nikonsalesVO vo) {
		int cnt = 0;
		try {
			con = DBConn.getConnection();
			String sql = "update nikonsales set sid=?, sprice=?, splace=?, srecieve=? where scode=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getSid());
			stmt.setInt(2, vo.getSprice());
			stmt.setString(3, vo.getSplace());
			stmt.setString(4, vo.getSrecieve());
			stmt.setString(5, vo.getScode());
			cnt = stmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	
	
	public int deletenikonssales(nikonsalesVO vo) {
		int cnt=0;
		try {
			con = DBConn.getConnection();
			String sql = "delete from nikonsales where scode=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getScode());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
}