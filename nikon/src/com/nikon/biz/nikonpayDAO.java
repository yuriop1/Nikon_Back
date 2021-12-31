package com.nikon.biz;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nikon.model.DBConn;
import com.nikon.model.nikonnoticeVO;
import com.nikon.model.nikonpayVO;
import com.nikon.model.nikonproductVO;

public class nikonpayDAO {
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public ArrayList<nikonpayVO> getnikonpayList() { 
		ArrayList<nikonpayVO> nikonpayList = null;
		try {
			con = DBConn.getConnection();
			String sql = "select * from nikonpay";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			nikonpayList = new ArrayList<nikonpayVO>();
			while(rs.next()) {
				//데이터베이스 테이블에서 반환된 결과세트를 각 컬럼별로 지역변수에 담기
				String payid = rs.getString("payid");
				String userid = rs.getString("userid");
				int proid = rs.getInt("proid");
				int cnt = rs.getInt("cnt");
				String addr1 = rs.getString("addr1");
				String contact = rs.getString("contact");
				int paytype = rs.getInt("paytype");		
				String creditnum = rs.getString("creditnum");
				String credipw = rs.getString("credipw");
				
				//각 지역변수에 담긴 필드값을 VO에 담기
				nikonpayVO nikonpay = new nikonpayVO();
				nikonpay.setCredipw(credipw);
				nikonpay.setUserid(userid);
				nikonpay.setProid(proid);
				nikonpay.setCnt(cnt);
				nikonpay.setAddr1(addr1);
				nikonpay.setContact(contact);
				nikonpay.setPaytype(paytype);
				nikonpay.setCreditnum(creditnum);
				nikonpay.setCredipw(credipw);
				
				//VO에 담긴 데이터를 LIST에 담기
				nikonpayList.add(nikonpay);
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
		return nikonpayList;
	}
	
	
	
	public ArrayList<nikonpayVO> getUsernikonpayList(nikonpayVO vo){
		ArrayList<nikonpayVO> payList = null;
		String sql;
		try {
			DBConn.getConnection();
			sql = "select * from nikonpay shere userid=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getUserid());
			rs = stmt.executeQuery();
			payList = new ArrayList<nikonpayVO>();
			while(rs.next()) {
				nikonpayVO nikonpay = new nikonpayVO();
				nikonpay.setPayid(rs.getString("payid"));
				nikonpay.setUserid(rs.getString("userid"));
				nikonpay.setProid(rs.getInt("proid"));
				nikonpay.setCnt(rs.getInt("cnt"));
				nikonpay.setAddr1(rs.getString("addr1"));
				nikonpay.setContact(rs.getString("contact"));
				nikonpay.setPaytype(rs.getInt("paytype"));
				nikonpay.setCreditnum(rs.getString("creditnum"));
				nikonpay.setCredipw(rs.getString("credipw"));
				
				//VO에 담긴 데이터를 LIST에 담기
				payList.add(nikonpay);
			}
			rs.close();
			stmt.close();
//-> 뭔지 모르겠어
			
//			System.out.println(payList.size());
//			for(int i=0;i<payList.size();i++) {
//				nikonpayVO pay = null;
//				pay = payList.get(i);
//				nikonproductVO pcode = new nikonproductVO();
//				pcode = this.getPcode(pay.getPcode());
//				System.out.println("제품명:"+pro.getProname());
//				pay.setProname(nikonproduct.getPcode());				
//			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, con);
		}
		return payList;
	}
	
	
	public int updatenikonpay(nikonpayVO vo) {
		int cnt = 0;
		try {
			con = DBConn.getConnection();
			String sql = "update nikonpay set proid=?, cnt=?, addr1=?, contact=?, paytype=?, creditnum=?, credipw=? where payid=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, vo.getProid());
			stmt.setInt(2, vo.getCnt());
			stmt.setString(3, vo.getAddr1());
			stmt.setString(4, vo.getContact());
			stmt.setInt(5, vo.getPaytype());
			stmt.setString(6, vo.getCreditnum());
			stmt.setString(7, vo.getCredipw());
			stmt.setString(8, vo.getPayid());	
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	public int deletenikonpay(nikonpayVO vo) {
		int cnt=0;
		try {
			con = DBConn.getConnection();
			String sql = "delete from nikonpay where payid=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getPayid());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	public int addnikonpay(nikonpayVO vo) {
		int cnt = 0;
		String sql;
		try {
			con = DBConn.getConnection();
			sql = "insert into nikonpay values(inform_seq.nextval, ?, ?, ?, sysdate, 2, 'admin', 0)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getPayid());
			stmt.setString(2, vo.getUserid());
			stmt.setInt(3, vo.getProid());
			stmt.setInt(4, vo.getCnt());
			stmt.setString(5, vo.getAddr1());
			stmt.setString(6, vo.getContact());
			stmt.setInt(7, vo.getPaytype());
			stmt.setString(8,  vo.getCreditnum());
			stmt.setString(9,  vo.getCredipw());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
}