package work.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import work.model.dto.AirplaneDto;
import work.model.dto.NoticeDto;
import work.model.service.AirplaneService;
import work.model.service.NoticeService;

/**
 * Servlet implementation class MainController
 */
public class MainController extends HttpServlet {
	private NoticeService nservice = new NoticeService();
	private NoticeDto ndto = new NoticeDto();
	private AirplaneService aservice = new AirplaneService();
	private AirplaneDto adto = new AirplaneDto();
	private String str = null;

	
	protected void NoticeMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<NoticeDto> rows = nservice.selectAll(ndto);
		
		request.setAttribute("noticemain", rows);
		request.getRequestDispatcher("/NoticeMain.jsp").forward(request, response);
	}
	
	protected void ViewAirplane(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AirplaneDto view = aservice.viewAirplane(Integer.parseInt(request.getParameter("a_num")));
		System.out.println(view);
		
		request.setAttribute("viewairplane", view);
		AirplaneMain(request, response);
		
	}
	
	protected void AirplaneMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<AirplaneDto> airname = aservice.selectTitle(adto);
		
		request.setAttribute("airplanemain", airname);
		request.getRequestDispatcher("/AirplaneMain.jsp").forward(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("action = "+action);
		
		
		switch(action) {
		case "noticemain" : 
			NoticeMain(request, response); 
			break;
		case "airplanemain" :
			AirplaneMain(request,response);
			break;
		case "airplaneView" :
			ViewAirplane(request,response);
			break;
		default : System.out.println("지원 안되는 서비스다.");
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
		process(request, response);
	}

}
