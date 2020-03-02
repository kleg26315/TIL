package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.dao.EmployeeDAO;
import com.kh.model.vo.Employee;
import com.kh.view.Menu;

public class EmployeeController {
	// View에서 전달 받은 데이터를 가공처리(데이터 변환, 디코딩 등...) 하여 dao로 전달
	// dao로부터 전달 받은 결과에 따라 view(출력화면)를 결정하여 데이터 전송
	private EmployeeDAO empDAO = new EmployeeDAO();
	private Menu menu = new Menu();
	
	// 전체 사원 정보 조회
	public void selectAll() {
		ArrayList<Employee> empList = empDAO.selectAll();
		
		if(!empList.isEmpty()) { // 조회결과가 있을 경우
			menu.selectAll(empList);
		} else { // 조회결과가 없을 경우
			menu.displayError("조회 결과가 없습니다.");
		}
	}
	
	// 사번으로 사원 정보 조회
	public void selectEmployee() {
		// 사번 입력 view 호출
		int empNo = menu.selectEmpNo();
		Employee emp = empDAO.selectEmployee(empNo);
		
		if(emp != null) { // 사원 존재
			menu.selectEmployee(emp);
		} else { // 사원 존재 x
			menu.displayError("해당 사번의 검색 결과가 없습니다.");
		}
	}
	
	// 새로운 사원 정보 추가
	public void insertEmployee() {
		Employee emp = menu.insertEmployee();
		int result = empDAO.insertEmployee(emp);
		
		if(result > 0) {
			menu.displaySuccess(result + "개의 행이 추가 되었습니다.");
		} else {
			menu.displayError("데이터 삽입 과정 중 오류 발생");
		}
	}
	
	// 사번으로 사원 정보 수정
	public void updateEmployee() {
		int empNo = menu.selectEmpNo();
		
		Employee emp = menu.updateEmployee();
		emp.setEmpNo(empNo);
		
		int result = empDAO.updateEmployee(emp);
		
		if(result>0) {
			menu.displaySuccess(result + "개의 행이 수정되었습니다.");
		} else {
			menu.displayError("데이터 수정 과정 중 오류 발생");
		}
	}

	// 사번으로 사원 정보 삭제
	public void deleteEmployee() {
		int empNo = menu.selectEmpNo();
		
		char check = menu.deleteEmployee();
		
		if(check == 'y') {
			int result = empDAO.deleteEmployee(empNo);
			
			if(result>0) {
				menu.displaySuccess(result + "개의 행이 삭제되었습니다.");
			} else {
				menu.displayError("데이터 삭제 과정 중 오류 발생");
			}
		} else if(check == 'n') {
			menu.displaySuccess("사원 정보 삭제 취소");
		} else {
			menu.displayError("잘못 입력하셨습니다. (y 또는 n 입력)");
		}
	}
}
