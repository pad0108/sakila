package sakila.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import sakila.service.*;
import sakila.vo.*;



@WebServlet("/auth/StaffInfoServlet")
public class StaffInfoServlet extends HttpServlet {
	private StaffInfoService staffInfoService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//디버깅
		System.out.println("StaffInfoServlet 실행 확인 ------");
		
		HttpSession session = request.getSession();
		
		staffInfoService = new StaffInfoService();
		StaffInfo staffInfo = new StaffInfo();
		staffInfo = new StaffInfo();
		
		//디버깅
		System.out.println("staffInfo 객체 생성 확인-----");
		
		Staff staff = (Staff) session.getAttribute("loginStaff");
		
		staffInfo.setStaffId(staff.getStaffId()); //staff에 저장된 staffId를 staffInfo의 staffId에 저장
		
		StaffInfo returnStaffInfo = staffInfoService.getStaffInfo(staffInfo); //staff의 정보 불러옴
		if(returnStaffInfo !=null) { //email 과 password가 일치할 경우
			request.setAttribute("staffInfo", returnStaffInfo);
			
		}
		request.getRequestDispatcher("/WEB-INF/views/auth/staffInfo.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
