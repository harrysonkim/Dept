package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.Dept;

public interface DeptDao {

	/**
	 * 전체 부서 정보를 조회한다
	 * 
	 * @param conn - DB연결 객체
	 * @return 전체 부서 목록
	 */
	public List<Dept> selectAll(Connection conn);

	/**
	 * 
	 * @param conn
	 * @param dept 
	 * @return
	 */
	public int insert(Connection conn, Dept dept);

}
