package work.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import work.model.service.BboardService;
import work.model.service.BmemberService;

/**
 * Servlet implementation class BorderServlet
 */
public class BorderServlet extends HttpServlet {
	
	//service 객체
	private BboardService bbs = new BboardService();

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
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
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("chu");
		switch(action) {
		case "list": list(request, response);
			break;
		case "move": move(request, response);
			break;
		default :
			System.out.println("Error");
		}
	}

	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String choice = request.getParameter("selected");
		String pages = request.getParameter("listed");
		int num = Integer.parseInt(choice);
		int page = Integer.parseInt(pages);
		ArrayList al;
		al = bbs.bboardSelectAll(num, page);
		int last = bbs.bboardLast();
		if (al == null) {
			request.setAttribute("result", al);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Board.jsp");
			dispatcher.forward(request, response);
		} else {
			al.add(choice);
			al.add(last);
			request.setAttribute("result", al);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Board.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	protected void move(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String choice = request.getParameter("selected");
		String pages = request.getParameter("listed");
		int num = Integer.parseInt(choice);
		int page = Integer.parseInt(pages);
		ArrayList al;
		al = bbs.bboardSelectAll(num, page);
		int last = bbs.bboardLast();
		if (al == null) {
			request.setAttribute("result", al);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Board.jsp");
			dispatcher.forward(request, response);
		} else {
			al.add(choice);
			al.add(last);
			request.setAttribute("result", al);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Board.jsp");
			dispatcher.forward(request, response);
		}
	}
	
}
