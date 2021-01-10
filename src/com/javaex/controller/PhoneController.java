package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhoneDao;
import com.javaex.utill.WebUtill;
import com.javaex.vo.PhoneVo;

@WebServlet("/pbc")
public class PhoneController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 컨트롤러 테스트
		System.out.println("controller");

		// 파라미터 action 값을 읽어서
		String action = request.getParameter("action");
		System.out.println(action);
		
		
		if ("wform".equals(action)) {
			System.out.println("등록 폼 처리");
			
			/*
			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/writeform.jsp");
			rd.forward(request, response);
			*/
			WebUtill.forward(request, response, "./WEB-INF/writeform.jsp");
		
		} else if ("insert".equals(action)) {
			System.out.println("전화번호 저장");

			// 파라미터 3개 값
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");

			// phoneVo로 묶고
			PhoneVo phoneVo = new PhoneVo(name, hp, company);

			// new dao --> 저장
			PhoneDao phoneDao = new PhoneDao();
			// dao personInsert(phoneVo)
			phoneDao.personInsert(phoneVo);
			
			/*
			response.sendRedirect("/phonebook2/pbc?action=list");
			*/
			WebUtill.redirect(request, response, "/phonebook2/pbc?action=list");
	
		} else if("delete".equals(action)) {
			System.out.println("정보 삭제");
			
			//id 값 int로 저장
			int personid = Integer.parseInt(request.getParameter("id"));
			
			//Dao에 id값 넣기
			PhoneDao phoneDao = new PhoneDao();
			phoneDao.phoneDelete(personid);
			
			//리스트 화면 출력
			response.sendRedirect("/phonebook2/pbc?action=list");
			
		} else if("upForm".equals(action)) { //리스트와 비슷
			System.out.println("정보 수정폼");
			
			//id값 int로 저장
			int personId = Integer.parseInt(request.getParameter("id"));	
			
			
			PhoneDao phoneDao = new PhoneDao();
			
			//Dao기능을 Vo로 받기
			PhoneVo phoneVo = phoneDao.getPerson(personId); 
			
			//데이터 전달기능
			request.setAttribute("udVo", phoneVo);
			
			//jsp에 받은 데이터 전송
			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/upForm.jsp"); 
			rd.forward(request, response);
			
			//리스트 화면 출력
			response.sendRedirect("/phonebook2/pbc?action=list");
			
		} else if("update".equals(action)) {
			System.out.println("정보 수정");
			
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			int personId = Integer.parseInt(request.getParameter("id"));
			
			
			PhoneVo phoneVo = new PhoneVo(personId, name, hp, company);
			
			PhoneDao phoneDao = new PhoneDao();
			phoneDao.personUpdate(phoneVo);
			
			//리스트 화면 출력
			response.sendRedirect("/phonebook2/pbc?action=list");
			
		} else{ //기본값을 리스트로
			System.out.println("리스트 처리");

			// 리스트 출력 처리
			PhoneDao phoneDao = new PhoneDao();
			List<PhoneVo> personList = phoneDao.getPersonList();

			// html -->엄청 복잡함. -->jsp에서 짜는게 편하다.

			// 데이터 전달
			request.setAttribute("pList", personList);

			// jsp에 포워드 시킨다.
			/*
			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/list.jsp"); // jsp파일 위치
			rd.forward(request, response);
			*/
			
			WebUtill.forward(request, response, "./WEB-INF/list.jsp");
			
		}
			

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);

	}

}
