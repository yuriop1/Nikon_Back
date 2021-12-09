package com.shop.biz;

import java.sql.*;
import java.util.ArrayList;

import com.shop.model.DBConn;
import com.shop.model.NikonNoticeVO;
public class NikonNoticeDAO {
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public ArrayList<NikonNoticeVO> getNikonNoticeList() {
		ArrayList<NikonNoticeVO> nikonnoticeList = null;
		try {
			con = DBConn.getConnection();
			String sql = "select * from nikonnotice order by regdate desc, seq asc";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			nikonnoticeList = new ArrayList<NikonNoticeVO>();
			while(rs.next()) {
				int seq = rs.getInt("seq");
				String nname = rs.getString("nname");
				String ntit = rs.getString("ntit");
				String ncon = rs.getString("ncon");
				Date nregdate = rs.getDate("nregdate");
				int nvisited = rs.getInt("nvisited");
				
				NikonNoticeVO nikonnotice = new NikonNoticeVO();
				nikonnotice.setSeq(seq);
				nikonnotice.setNname(nname);
				nikonnotice.setNtit(ntit);
				nikonnotice.setNcon(ncon);
				nikonnotice.setNregdate(nregdate);
				nikonnotice.setNvisited(nvisited);
				
				nikonnoticeList.add(nikonnotice);				
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
		return nikonnoticeList;
	}
	
	public NikonNoticeVO getNikonNotice(NikonNoticeVO vo) {
		NikonNoticeVO nikonnotice = null;
		try {
			con = DBConn.getConnection();
			String sql = "update nikonnotice set nvisited=nvisited+1 where seq = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, vo.getSeq());
			int cnt = stmt.executeUpdate();
			stmt.close();
			if(cnt>0) {
				sql = "select * from nikonnotice where seq = ?";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, vo.getSeq());
				rs = stmt.executeQuery();
				if(rs.next()) {				
					nikonnotice = new NikonNoticeVO();
					nikonnotice.setSeq(rs.getInt("seq"));
					nikonnotice.setNname(rs.getString("nname"));
					nikonnotice.setNtit(rs.getString("ntit"));
					nikonnotice.setNcon(rs.getString("ncon"));
					nikonnotice.setNregdate(rs.getDate("nregdate"));
					nikonnotice.setNvisited(rs.getInt("nvisited"));
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, con);
		}
		return nikonnotice;	
	}
	public int updateNikonNotice(NikonNoticeVO vo) {
		int cnt = 0;
		try {
			con = DBConn.getConnection();
			String sql = "update nikonnotice set ntit=?, ncon=? where seq=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getNtit());
			stmt.setString(2, vo.getNcon());
			stmt.setInt(3, vo.getSeq());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	public int deleteNikonNotice(NikonNoticeVO vo) {
		int cnt=0;
		try {
			con = DBConn.getConnection();
			String sql = "delete from inform where seq=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, vo.getSeq());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
	public int addNikonNotice(NikonNoticeVO vo) {
		int cnt = 0;
		try {
			con = DBConn.getConnection();
			String sql = "insert into nikonnotice values(inform_seq.nextval, ?, ?, ?, sysdate, 0)";
			stmt.setString(1, vo.getNname());
			stmt.setString(2,  vo.getNtit());
			stmt.setString(3, vo.getNcon());
			cnt = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt, con);
		}
		return cnt;
	}
}