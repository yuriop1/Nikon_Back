package com.nikon.biz;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nikon.model.DBConn;
import com.nikon.model.nikonnoticeVO;

public class nikonnoticeDAO2 {
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
		
	public List<nikonnoticeVO> getList(int startRow, int endRow) {
		List<nikonnoticeVO> list = null;
		try {
			con = DBConn.getConnection();
			String sql = "select * from (select rownum as rn, seq, nname, ntit, ncom, nregdate, nvisited from (select * from nikonnotice order by seq desc)) where rn between ? and ?";
			stmt = con.prepareStatement(sql); // sql 정의
			stmt.setInt(1, startRow); // sql 물음표에 값 매핑
			stmt.setInt(2, endRow);
			rs = stmt.executeQuery(); // sql 실행
			if (rs.next()) { // 데이터베이스에 데이터가 있으면 실행
				list = new ArrayList<>(); // list 객체 생성
				do {
					nikonnoticeVO nikonnotice = new nikonnoticeVO();
					nikonnotice.setSeq(rs.getInt("seq"));
					nikonnotice.setNname(rs.getString("nname"));
					nikonnotice.setNtit(rs.getString("ntit"));
					nikonnotice.setNcon(rs.getString("ncon"));
					nikonnotice.setNregdate(rs.getDate("nregdate"));
					nikonnotice.setNvisited(rs.getInt("nvisited"));
					list.add(nikonnotice);
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs, stmt, con);
		}
	return list; // list 반환
}
	
	// 총 레코드 수 구하는 로직
		public int getCount(){
			int count = 0;
			String sql = "select count(*) from nikonnotice";
			try {
				con = DBConn.getConnection();
				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				if(rs.next()){
					count = rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBConn.close(rs, stmt, con);
			}
			return count; // 총 레코드 수 리턴
		}
	}
