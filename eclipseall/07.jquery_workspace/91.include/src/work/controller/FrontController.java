package work.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("\n### action : " + action);
		switch(action) {
		case "memberList":
			memberList(request, response);
			break;
		default:
			request.setAttribute("message", "지원되지 않는 서비스 요청입니다.");
			// 해당 컨텍스트를 기준으로 상대경로 지정
			//request.getRequestDispatcher("/error/fail.jsp").forward(request, response);
			
			response.sendRedirect("error/fail.jsp");
			break;
		}
	}
	
	protected void memberList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("### memberList service() start");
		request.setAttribute("title", "전체회원조회");
		// 해당 컨텍스트를 기준으로 상대경로 지정
		request.getRequestDispatcher("/member/memberList.jsp").forward(request, response);
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
