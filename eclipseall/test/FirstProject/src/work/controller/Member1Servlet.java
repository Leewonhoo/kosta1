package work.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import work.model.service.BmemberService;

/**
 * Servlet implementation class ModelServlet
 * 
 * controller의 정의
 * - 사용자가 입력한 정보, 전달 방법 처리
 * - 
 * 
 */
public class Member1Servlet extends HttpServlet {

	//service 객체
	private BmemberService bs = new BmemberService();
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("HO");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	/**
	 * @see HttpServlet#process(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getMethod());
		String action = request.getParameter("action");
		System.out.println("action : "+action);
		switch(action) {
		case "login": login(request, response);
			break;
		case "logout":
			break;
		case "idsearch": idSearch(request, response);
			break;
		case "pw search": pwSearch(request, response);
			break;
		default :
			System.out.println("Error");
		}
	}
	
	/**
	 * @see HttpServlet#login(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("memberId");
		String pw = request.getParameter("memberPw");
		
		// 아이디, 비밀번호 필수 입력항목 검증
		if ((id == null) || (id.trim().length() == 0)) {
			System.out.println("id 없음");
			request.setAttribute("errorMessage", "id X");   //메시지 설정 (key, value)
			//request.getRequestDispatcher("/Error.jsp").forward(request, response);
			//기존 요청, 응답객체 정보를 가지고 다른자원으로 포워드 이동
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(request, response);
		}
		if ((pw == null) || (pw.trim().length() == 0)) {    //비밀번호 길이 및 확인
			System.out.println("pw 없음");
			//새로운 요청으로 페이지 이동하는 것이므로 앞선 요청에서 설정된 것들은 모두 사라짐
			response.sendRedirect("Login.jsp");
		}
		
		String a = bs.bmemberlogin(id, pw);
		if(a!=null) {
			System.out.println("성공");
			request.setAttribute("errorMessage", "성공");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(request, response);
		} else {
			System.out.println("실패");
			request.setAttribute("errorMessage", "실패");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#idSearch(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void idSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("idName");
		String year = request.getParameter("sel_year");
		String month = request.getParameter("sel_month");
		String day = request.getParameter("sel_day");
		String question = request.getParameter("sel_question");
		String answer = request.getParameter("idAnswer");
		System.out.println(name+" | "+year+" | "+month+" | "+day+" | "+question+" | "+answer);
	}
	
	/**
	 * @see HttpServlet#pwSearch(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void pwSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pwId");
		String name = request.getParameter("pwName");
		String year = request.getParameter("sel_year");
		String month = request.getParameter("sel_month");
		String day = request.getParameter("sel_day");
		String question = request.getParameter("sel_question");
		String answer = request.getParameter("idAnswer");
		System.out.println(id+" | "+name+" | "+year+" | "+month+" | "+day+" | "+question+" | "+answer);
	}
	
}
