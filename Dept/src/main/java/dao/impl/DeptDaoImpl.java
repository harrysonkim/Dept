package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import dao.face.DeptDao;
import dto.Dept;

public class DeptDaoImpl implements DeptDao {

	@Override
	public List<Dept> selectAll(Connection conn) {

		PreparedStatement ps = null;
		
		ResultSet rs = null;

		String sql = "";
		sql += "SELECT * FROM dept";
		sql += " ORDER BY deptno";

		List<Dept> list = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while( rs.next()) {
				Dept dept = new Dept();
				
				dept.setDeptno( rs.getInt("deptno"));
				dept.setDname( rs.getString("dname"));
				dept.setLoc( rs.getString("loc"));
				
				list.add(dept);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		
		

		return list;
	}

	@Override
	public int insert(Connection conn, Dept dept) {

		PreparedStatement ps = null;
		
		String sql = "";
		sql += "INSERT INTO dept (deptno, dname, loc)";
		sql += " VALUES (?, ?, ?)";
		
		int result = 0;
		
		try {
			  
			

			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, dept.getDeptno());
			ps.setString(2, dept.getDname());
			ps.setString(3, dept.getLoc());
			
			result = ps.executeUpdate();		

			JDBCTemplate.commit(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		
		}
		
		
		return result;
	}

}
