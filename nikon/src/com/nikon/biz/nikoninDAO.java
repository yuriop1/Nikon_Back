package com.nikon.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nikon.model.DBConn;
import com.nikon.model.nikoninVO;

public class nikoninDAO {
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public ArrayList<nikoninVO> getnikoninList() {
		ArrayList<nikoninVO> nikoninList = null;
		try {
			con = DBConn.getConnection();
			String sql = "select * from nikonin";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			nikoninList = new ArrayList<nikoninVO>();
			while(rs.next()) {
				int icode = rs.getInt("icode");
				String iid = rs.getString("iid");
				String iname = rs.getString("iname");
				String iprice = rs.getString("iprice");
				
				nikoninVO nikonin = new nikoninVO();
				nikonin.setIcode(icode);
				nikonin.setIid(iid);
				nikonin.setIname(iname);
				nikonin.setIprice(iprice);	
				nikoninList.add(nikonin);
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
		return nikoninList;
	}
	
	public nikoninVO getnikonin(nikoninVO vo) { 
		nikoninVO nikonin = null;
		try {
			con = DBConn.getConnection();
				String sql = "select * from nikonin where icode = ?";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, vo.getIcode());
				rs = stmt.executeQuery();
				if(rs.next()) {
					nikonin = new nikoninVO();
					nikonin.setIcode(rs.getInt("icode"));
					nikonin.setIid(rs.getString("iid"));
					nikonin.setIname(rs.getString("iname"));
					nikonin.setIprice(rs.getString("iprice"));
				}	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, con);
		}
		return nikonin;
	}
	

	public int addnikonin(nikoninVO vo) {	
		int cnt = 0;
		try {
			con = DBConn.getConnection();
			String sql = "insert into nikonin values(?, ?, ?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, vo.getIcode());
			stmt.setString(2, vo.getIid());
			stmt.setString(3, vo.getIname());
			stmt.setString(4,  vo.getIprice());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	
	public int updatenikonin(nikoninVO vo) {	
		int cnt = 0;
		try {
			con = DBConn.getConnection();
			String sql = "update nikonin set iid=?, iname=?, iprice=? where icode=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getIid());
			stmt.setString(2,  vo.getIname());
			stmt.setString(3, vo.getIprice());
			stmt.setInt(4, vo.getIcode());
			cnt = stmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	
	
	public int deletenikonin(nikoninVO vo) {	
		int cnt=0;
		try {
			con = DBConn.getConnection();
			String sql = "delete from nikonin where icode=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, vo.getIcode());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
}