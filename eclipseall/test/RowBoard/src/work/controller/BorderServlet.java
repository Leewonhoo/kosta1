package work.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import work.model.dto.Bboard;
import work.model.service.BboardService;

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
		String action = request.getParameter("action");
		switch(action) {
		case "list": list(request, response);
			break;
		default :
			System.out.println("Error");
		}
	}

	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("selected"));
		int page = Integer.parseInt(request.getParameter("listed"));
		HashMap<Integer, Bboard> Hash = bbs.bboardSelectAll(num, page);
		int last = bbs.bboardLast();
		if (Hash == null) {
			request.setAttribute("result", null);
		} else {
			Hash.put(-1, new Bboard(num, page, last));
			request.setAttribute("result", Hash);
		}
		request.getRequestDispatcher("/Board.jsp").forward(request, response);
	}
	
}
