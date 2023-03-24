package controllor;

import java.util.List;
import java.util.Scanner;

import dto.Dept;
import service.face.DeptService;
import service.impl.DeptServiceImpl;

public class DeptControllor {

//	키보드 입력 객체
	private static Scanner sc = new Scanner(System.in);

	// 서비스 객체
	private static DeptService deptService = new DeptServiceImpl();

	private static void menu() {
		System.out.println("+ + + M E B U + + +");
		System.out.println("수행할 기능 번호를 입력하세요");
		System.out.println();
		System.out.println("1.부서 정보 전체 조회");
		System.out.println("2.부서 정보 입력");
		System.out.println("3.부서번호로 부서정보 조회");

		// 메뉴 선택 변수
		int sel = 0;
		System.out.println("\t>> ");
		sel = sc.nextInt();

		System.out.println("\n----------------------------------");

		switch (sel) {
		case 1:

			// 기능 수행
			System.out.println("===== 1.부서 정보 전체 조회 =====");

			List<Dept> list = deptService.list();

			for (Dept dept : list) {

				System.out.println(dept);
			}

			break;

		case 2:
			System.out.println("===== 2.부서 정보 입력 =====");
			
			Dept dept = new Dept();
			System.out.println("부서 번호를 입력 해주세요");
			dept.setDeptno(sc.nextInt());
			sc.nextLine();
			System.out.println("부서 이름를 입력 해주세요");
			dept.setDname(sc.nextLine());
			System.out.println("부서 위치를 입력 해주세요");
			dept.setLoc(sc.nextLine());
			
			System.out.println(dept);
			
			int insert_Result = deptService.insert(dept);
			
			  
			if (insert_Result > 0) {
				System.out.println("정보 추가 성공");
			}else {
				System.out.println("정보 추가 실패");
			}

			break;
		
		case 3:
			System.out.println("===== 3.부서번호로 부서정보 조회 =====");

			break;

		case 0:
			System.out.println("종료");
			break;
			
		default:
			System.out.println("1~3메뉴만 선택 해주세요 (종료 : 0)");
			break;
		}

	}

	public static void main(String[] args) {

		menu();

	}

}
