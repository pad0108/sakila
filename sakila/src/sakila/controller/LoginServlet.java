package sakila.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import sakila.service.StatsService;
import sakila.vo.*;
import sakila.service.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private StatsService statsService;
	private StaffService staffService;
	
	// 로그인 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 로그인 정보가 세션에 있을 경우 -> 메인 페이지로 이동 
		// 로그인 정보가 세션에 없을경우 -> 로그인 페이지로 이동
		if(session.getAttribute("loginStaff") != null) {
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");
			return;
		}
		// 오늘 접속자 수 폼에 넘겨주기
		statsService = new StatsService();
		Map<String, Object> map = statsService.getStats();
		
		Stats todayStats = (Stats) map.get("todayStats");
		int totalCnt = (Integer) map.get("totalCnt");
		request.setAttribute("todayStats", todayStats);
		request.setAttribute("totalCnt", totalCnt);
				
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	// 로그인 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		staffService = new StaffService();
		
		// 디버깅
		System.out.println(request.getParameter("id")+"id------");
		System.out.println(request.getParameter("pw")+"pw------");
		
		// 로그인 정보 받아오기, staff에 정보 저장
		Staff staff = new Staff();
		staff.setEmail(request.getParameter("id"));
		staff.setPassword(request.getParameter("pw"));
		
		// 서비스에서 인증 결과 받아오기
		Staff returnStaff = staffService.getStaffByKey(staff);
		
		//로그인 실패 시 로그인 페이지에 머뭄
		if(returnStaff == null) {
			System.out.println("로그인 실패");
			response.sendRedirect(request.getContextPath() + "/LoginServlet");	
			
		}else {//로그인 성공 시 인덱스로 넘어감
			session.setAttribute("loginStaff", returnStaff);
			
			System.out.println(returnStaff + "로그인 성공");
			response.sendRedirect(request.getContextPath() + "/auth/IndexServlet");
		}
		
	}

}
