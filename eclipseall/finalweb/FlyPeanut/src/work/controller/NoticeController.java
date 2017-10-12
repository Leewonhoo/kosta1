package work.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import work.model.dto.NoticeDto;
import work.model.service.NoticeService;

/**
 * Servlet implementation class NoticeController
 */
public class NoticeController extends HttpServlet {
	
	private NoticeService nservice = new NoticeService();
	private NoticeDto ndto = new NoticeDto();
	
	/**
	 * <pre>
	 * 공지 전체 출력
	 * </pre>
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void NoticeView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDto view = nservice.seeNotice(Integer.parseInt(request.getParameter("n_num")));
		request.setAttribute("noticeView", view);
		request.getRequestDispatcher("/NoticeView.jsp").forward(request, response);
	
	}
	
	/**
	 * <pre>
	 * 공지 쓰기
	 * </pre>
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void NoticeWrite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		int nwrite = nservice.writeNotice(title,contents);
		if(nwrite == 1)
		{
		request.setAttribute("noticewrite", nwrite);
		request.getRequestDispatcher("/MainController?action=noticemain").forward(request, response);
		}
		else {
			System.out.println("공지 쓰기실패");
		}
	}
	

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action) {
		case "noticeview" : 
			NoticeView(request, response); 
			break;
		case "noticewrite" : 
			NoticeWrite(request, response); 
			break;
		default : System.out.println("지원안됨");
		}
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
