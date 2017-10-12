package work.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import work.Dto.FlightDto;
import work.Service.FlightService;

/**
 * Servlet implementation class AirController
 */
public class AirController extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String action = request.getParameter("action");
		System.out.println("action : "+action);
		switch(action) {
		case "a_flight": selectFlight(request, response);
			break;
		case "a_seat": selectSeat(request, response);
			break;
		case "choice": seatminus(request, response);
			break;
		default:
			System.out.println("Error!");
		}
	}
	
	private void selectFlight(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlightService flightS = new FlightService();
		String nation1 = request.getParameter("leave_nation1");
		String city1 = request.getParameter("leave_city1");
		String nation2 = request.getParameter("arrive_nation1");
		String city2 = request.getParameter("arrive_city1");
		String nation3 = request.getParameter("leave_nation2");
		String city3 = request.getParameter("leave_city2");
		System.out.println("city : "+city3);
		String nation4 = request.getParameter("arrive_nation2");
		String city4 = request.getParameter("arrive_city2");
		String leave1 = "";
		String arrive1 = "";
		String leave2 = "";
		String arrive2 = "";
		ArrayList<FlightDto> result1 = null;
		ArrayList<FlightDto> result2 = null;
		if((nation1 != null) && (nation1.trim().length() > 0) && (city1 != null) && (city1.trim().length() > 0)) {
			leave1 = nation1+"-"+city1;
		}
		if((nation2 != null) && (nation2.trim().length() > 0) && (city2 != null) && (city2.trim().length() > 0)) {
			arrive1 = nation2+"-"+city2;
		}
		if((leave1 != null) && (leave1.trim().length() > 1) && (arrive1 != null) && (arrive1.trim().length() > 1)) {
			result1 = flightS.selectFlight(leave1, arrive1);
		}
		if((nation3 != null) && (nation3.trim().length() > 0) && (city3 != null) && (city3.trim().length() > 0)) {
			leave2 = nation3+"-"+city3;
		}
		if((nation4 != null) && (nation4.trim().length() > 0) && (city4 != null) && (city4.trim().length() > 0)) {
			arrive2 = nation4+"-"+city4;
		}
		if((leave2 != null) && (leave2.trim().length() > 1) && (arrive2 != null) && (arrive2.trim().length() > 1)) {
			result2 = flightS.selectFlight(leave2, arrive2);
		}
		request.setAttribute("radioch", request.getParameter("fly"));
		if(result1 != null) {
			request.setAttribute("list1", result1);
		} else {
			request.setAttribute("list1", null);
		}
		
		if(result2 != null) {
			request.setAttribute("list2", result2);
		} else {
			request.setAttribute("list2", null);
		}
		request.getRequestDispatcher("/Reservation.jsp").forward(request, response);
	}
	
	private void selectSeat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (Integer.parseInt(request.getParameter("ticketNumber")) == 1) {
			
		}
	}
	
	private void seatminus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
