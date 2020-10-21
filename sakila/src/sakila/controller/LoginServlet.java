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
	
	// �α��� ��
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginStaff") != null) {
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");
			return;
		}
		// ���� ������ �� ���� �Ѱ��ֱ�
		statsService = new StatsService();
		Map<String, Object> map = statsService.getStats();
		Stats todayStats = (Stats) map.get("todayStats");
		int totalCnt = (Integer) map.get("totalCnt");
		request.setAttribute("todayStats", todayStats);
		request.setAttribute("totalCnt", totalCnt);
				
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	// �α��� �׼�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		staffService = new StaffService();
		
		//id,pw�� ���������� Ȯ��
		System.out.println(request.getParameter("id")+"id------");
		System.out.println(request.getParameter("pw")+"pw------");
		
		//�α��� ���� �޾ƿ���
		Staff staff = new Staff();
		staff.setStaffId(Integer.parseInt(request.getParameter("id")));
		staff.setPassword(request.getParameter("pw"));
		
		//staffService���� ��� �޾ƿ���
		Staff returnStaff = staffService.getStaffByKey(staff);
		
		//�α��� ���н� �α��� �������� �̵�
		if(returnStaff == null) {
			System.out.println("�α��� ����");
			response.sendRedirect(request.getContextPath() + "/LoginServlet");	
			
		}else {//�α��� ���� �� index �������� �̵�
			session.setAttribute("loginStaff", returnStaff.getStaffId());
			System.out.println(returnStaff.getStaffId() + "�α��� ����");
			response.sendRedirect(request.getContextPath() + "/auth/IndexServlet");
		}
		
	}

}
