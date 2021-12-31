package com.nikon.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nikon.model.DBConn;
import com.nikon.model.nikonproductVO;
public class nikonproductDAO {
	
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public ArrayList<nikonproductVO> getnikonproductList() {
		ArrayList<nikonproductVO> nikonproductList = null;
		try {
			con = DBConn.getConnection();
			String sql = "select * from nikonproduct";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			nikonproductList = new ArrayList<nikonproductVO>();
			while(rs.next()) {
				String pcode = rs.getString("pcode");
				String pname = rs.getString("pname");
				String pinfo = rs.getString("pinfo");
				int pprice = rs.getInt("pprice");
				String pimg = rs.getString("pimg");
				
				nikonproductVO nikonproduct = new nikonproductVO();
				nikonproduct.setPcode(pcode);
				nikonproduct.setPname(pname);
				nikonproduct.setPinfo(pinfo);
				nikonproduct.setPprice(pprice);
				nikonproduct.setPimg(pimg);
				nikonproductList.add(nikonproduct);
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
		return nikonproductList;
	}
	
	public nikonproductVO getnikonproduct(nikonproductVO vo) {
		nikonproductVO nikonproduct = null;
		try {
			con = DBConn.getConnection();
				String sql = "select * from nikonproduct where pcode = ?";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, vo.getPcode());
				rs = stmt.executeQuery();
				if(rs.next()) {
					nikonproduct = new nikonproductVO();
					nikonproduct.setPcode(rs.getString("pcode"));
					nikonproduct.setPname(rs.getString("pname"));
					nikonproduct.setPinfo(rs.getString("pinfo"));
					nikonproduct.setPprice(rs.getInt("pprice"));
					nikonproduct.setPimg(rs.getString("pimg"));
					
				}	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, con);
		}
		return nikonproduct;
	}
	
	
	public int deletenikonproduct(nikonproductVO vo) {
		int cnt=0;
		try {
			con = DBConn.getConnection();
			String sql = "delete from nikonproduct where pcode=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getPcode());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	
	public int addnikonproduct(nikonproductVO vo) {
		int cnt = 0;
		try {
			con = DBConn.getConnection();
			String sql = "insert into nikonproduct values(?, ?, ?, ?, '관리자', ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getPcode());
			stmt.setString(2, vo.getPname());
			stmt.setString(3, vo.getPinfo());
			stmt.setInt(4, vo.getPprice());
			stmt.setString(5, vo.getPimg());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	public int updatenikonproduct(nikonproductVO vo) {
		int cnt = 0;
		try {
			con = DBConn.getConnection();
			String sql = "update nikonproduct set pname=?, pinfo=?, pprice=?, pimg=? where pcode=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "pname");
			stmt.setString(2, "pinfo");
			stmt.setString(3, "pprice");
			stmt.setString(4, "pimg");
			stmt.setString(5, "pcode");
			cnt = stmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
}
