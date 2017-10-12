package work.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	public ServletContext application;
	
	/**
	 * 서버 구동시 자동 로딩 초기화 수행시 context path 설정 초기화 수행
	 * view page 자원 리소스 지정시 사용 : ${applicationScope.CONTEXT_PATH}
	 * CONTEXT_PATH = "/sample"
	 */
	public void init() {
		application = getServletContext();
		application.setAttribute("CONTEXT_PATH", application.getContextPath());
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action) {
		case "memberInputSave":
			memberInputSave(request, response);
			break;
		default:
			request.setAttribute("fail.jsp", "");
		}
	}
	
	protected void memberInputSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		request.setCharacterEncoding("euc-kr");
		process(request, response);
	}

}
