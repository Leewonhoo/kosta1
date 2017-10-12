package work.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import work.model.dto.BoardDto;
import work.model.dto.ReplyDto;
import work.model.service.BoardService;

/**
 * Servlet implementation class BoardController
 */
public class BoardController extends HttpServlet {
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
		request.setCharacterEncoding("EUC-KR");
		process(request, response);
	}
	
	/**
	 * <pre>기능별 분리</pre>
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String action = request.getParameter("action");
		switch(action) {
		case "b_write": write(request,response);
			break;
		case "b_list": myList(request,response);
			break;
		case "b_detail": detail(request, response);
			break;
		case "b_delete": delete(request, response);
			break;
		default:
			System.out.println("Error!");
		}
	}
	
	/**
	 * <pre>게시글 작성 및 수정</pre>
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void write(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		BoardService boardS = new BoardService();
		BoardDto bor = new BoardDto();
		bor.setbNum(Integer.parseInt(request.getParameter("b_num")));
		bor.setbTitle(request.getParameter("b_title"));
		String content = request.getParameter("b_content");
		content.replaceAll("\r\n", "<br>");
		bor.setbContext(content);
		bor.setbWriter((String)session.getAttribute("userId"));
		if (boardS.insert(bor) == 1) {
			myList(request, response);
			request.setAttribute("message", "글 등록이 완료되었습니다.");
		} else {
			request.setAttribute("message", "글 등록에 실패하였습니다.");
		}
		request.getRequestDispatcher("/Board.jsp").forward(request, response);
	}
	
	/**
	 * <pre>내가 쓴 글 조회</pre>
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void myList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService boardS = new BoardService();
		HttpSession session = request.getSession(false);
		double select = 0;
		int pages = 1;
		if ((request.getParameter("show") == null) || (request.getParameter("show").trim().length()<1)){
			select = 3;
		} else {
			select = Integer.parseInt(request.getParameter("show"));
		}
		HashMap<Integer, BoardDto> list = boardS.myList((String)session.getAttribute("userId"));
		double mycount = boardS.mycount((String)session.getAttribute("userId"));
		if (request.getParameter("show") == null) {
			pages = 1;
		} else {
			pages = Integer.parseInt(request.getParameter("listed"));
		}
		if (list != null) {
			request.setAttribute("myList", list);
			request.setAttribute("select", select);
			request.setAttribute("myAll", mycount);
			request.setAttribute("pages", pages);
		} else {
			request.setAttribute("myList", list);
		}
		request.getRequestDispatcher("/Board.jsp").forward(request, response);
	}
	
	/**
	 * <pre>게시글 상세 조회</pre>
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService boardS = new BoardService();
		BoardDto dto = boardS.detail(Integer.parseInt(request.getParameter("b_num")));
		ReplyDto rdto = boardS.reply(Integer.parseInt(request.getParameter("b_num")));
		request.setAttribute("dto", dto);
		if (rdto != null) {
			request.setAttribute("rdto", rdto);
		} else {
			request.setAttribute("rdto", null);
		}
		request.getRequestDispatcher("/Bdetail.jsp").forward(request, response);
	}
	
	/**
	 * <pre>게시글 삭제</pre>
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService boardS = new BoardService();
		int bdelete = boardS.delete(Integer.parseInt(request.getParameter("mo_num")));
		if (bdelete == 1) {
			request.setAttribute("message", "게시글이 삭제 되었습니다.");
		} else {
			request.setAttribute("message", "게시글 삭제가 취소 되었습니다.");
		}
		request.getRequestDispatcher("/Board.jsp").forward(request, response);
	}

}
