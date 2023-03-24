package service.impl;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplate;
import dao.face.DeptDao;
import dao.impl.DeptDaoImpl;
import dto.Dept;
import service.face.DeptService;

// DAO는,
// Transaction 입장에서는 기능
// DB입장에서는 연속된 DML내역

public class DeptServiceImpl implements DeptService {

	private DeptDao deptDao = new DeptDaoImpl();
	
	@Override
	public List<Dept> list() {
	
		// Connection 객체
		Connection conn = JDBCTemplate.getConnection();

		// 부서목록 조회
		List<Dept> list = deptDao.selectAll(conn);
		
		// 조회된 목록 반환
		return list;

	}

	@Override
	public int insert(Dept dept) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = deptDao.insert(conn, dept);
		
		
		return result;
	}

}
