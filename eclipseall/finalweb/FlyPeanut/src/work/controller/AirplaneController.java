package work.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import work.model.dto.AirplaneDto;
import work.model.service.AirplaneService;

/**
 * Servlet implementation class AirplaneController
 */
public class AirplaneController extends HttpServlet {
	private AirplaneService aservice = new AirplaneService();

	protected void AddAirplane(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		String kind = request.getParameter("kind");
		String type = request.getParameter("type");
		System.out.println(type);
		int pax = Integer.parseInt(request.getParameter("pax"));
		String makeYear = request.getParameter("make_year");
		String makeMonth = request.getParameter("make_month");
		String makeDay = request.getParameter("make_day");
		String make = makeYear + "-" + makeMonth +"-"+ makeDay;
		String makeCompany = request.getParameter("makeCompany");
		String state = request.getParameter("state");
		int firstClassRow = Integer.parseInt(request.getParameter("firstclassrow"));
		String firstClassCol = request.getParameter("firstclasscol");
		System.out.println(firstClassCol);
		int businessClassRow = Integer.parseInt(request.getParameter("businessclassrow"));
		String businessClassCol = request.getParameter("businessclasscol");
		int economyClassRow = Integer.parseInt(request.getParameter("economyclassrow"));
		String economyClassCol = request.getParameter("economyclasscol");
		
		AirplaneDto adto = new AirplaneDto(num,kind,type,pax,make,makeCompany,state, 
				firstClassRow,firstClassCol, businessClassRow, businessClassCol, economyClassRow, economyClassCol);
		int result = aservice.addAirplane(adto);
		System.out.println(result);
		
		request.setAttribute("airplanemain", result);
		request.getRequestDispatcher("/AirplaneMain.jsp").forward(request, response);
	
	}
	

	
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("action = "+action);
		
		
		switch(action) {
		case "airplaneAdd" : 
			AddAirplane(request, response); 
			break;
		case "airplaneView" :
//			ViewAirplane(request,response);
			break;
		default : System.out.println("지원되지 않는 서비스다.");
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
