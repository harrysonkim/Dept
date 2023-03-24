package service.face;

import java.util.List;

import dto.Dept;

public interface DeptService {

	/**
	 * 전체 부서 목록 조회하기
	 * 
	 * @return 조회된 부서 목록
	 */
	public List<Dept> list();

	/**
	 * 
	 * @param dept
	 * @return
	 */
	public int insert(Dept dept);

}
