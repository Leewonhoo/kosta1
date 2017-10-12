package work.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import work.model.dto.AirplaneDto;
import work.model.dto.FlightDto;
import work.model.service.AirplaneService;
import work.model.service.FlightService;

/**
 * Servlet implementation class FlightController
 */
public class FlightController extends HttpServlet {
	private FlightService fservice = new FlightService();
	private AirplaneService aservice = new AirplaneService();
	private AirplaneDto adto = new AirplaneDto();
	private FlightDto fdto1 = new FlightDto();
	
	
	
	/**
	 * <pre>
	 * 운항정보 조회
	 * </pre>
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void FlightSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String leaveNation = request.getParameter("leave_nation");
		String leaveCity = request.getParameter("leave_city");
		String arriveNation = request.getParameter("arrive_nation");
		String arriveCity = request.getParameter("arrive_city");
		
		String leave = leaveNation +"-"+ leaveCity;
		String arrive = arriveNation +"-"+ arriveCity;
		ArrayList<FlightDto> result = fservice.FlightSelect(leave,arrive);
		
		request.setAttribute("flightview", result);
		request.getRequestDispatcher("/FlightView.jsp").forward(request, response);
	}
	
	/**
	 * <pre>
	 * 운항정보 등록
	 * </pre>
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void FlightWrite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String FDate = request.getParameter("f_date");
		int FAnum = Integer.parseInt(request.getParameter("f_anum"));
		String FFName = request.getParameter("f_fname");
		String FLeaveNation = request.getParameter("leave_nation");
		String FLeaveCity = request.getParameter("leave_city");
		String FLeave = FLeaveNation +"-"+ FLeaveCity;
		String FLeaveDate = request.getParameter("f_levdate");
		String FArriveNation = request.getParameter("arrive_nation");
		String FArriveCity = request.getParameter("arrive_city");
		String FArrive = FArriveNation +"-"+ FArriveCity;
		String FArriveDate = request.getParameter("f_arridate");
		int FGate = Integer.parseInt(request.getParameter("f_gate"));
		
		FlightDto fdto = new FlightDto(FDate, FAnum, FFName, FLeave, FLeaveDate, FArrive, FArriveDate, FGate);
		
		int result = fservice.FlightWrite(fdto);
		
		request.setAttribute("FlightView", result);
		request.getRequestDispatcher("/FlightView.jsp").forward(request, response);
	}
	
	/**
	 * <pre>
	 * 운항정보 출력
	 * </pre>
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void FlightCall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<AirplaneDto> airCall = aservice.selectTitle(adto);
		request.setAttribute("flightCall", airCall);
		request.getRequestDispatcher("/FlightWrite.jsp").forward(request, response);
	}
	
	/**
	 * <pre>
	 * 전체 출력(수정)
	 * </pre>
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void FlightAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<FlightDto> res = fservice.FlightAll(fdto1);
		request.setAttribute("flightAll", res);
		request.getRequestDispatcher("/FlightAll.jsp").forward(request, response);
	}
	
	/**
	 * 
	 * <pre>
	 * 전체출력(삭제)
	 * </pre>
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void FlightAll2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<FlightDto> res = fservice.FlightAll(fdto1);
		request.setAttribute("flightAll", res);
		request.getRequestDispatcher("/FlightDelAll.jsp").forward(request, response);
	}
	
	/**
	 * <pre>
	 * 운항정보 수정
	 * </pre>
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void FlightUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String FDate = request.getParameter("f_date");
		int FAnum = Integer.parseInt(request.getParameter("f_anum"));
		String FFName = request.getParameter("f_fname");
		String FLeave = request.getParameter("f_leave");
		String FLeaveDate = request.getParameter("f_levdate");
		String FArrive = request.getParameter("f_arrive");
		String FArriveDate = request.getParameter("f_arridate");
		int FGate = Integer.parseInt(request.getParameter("f_gate"));
		
		
		FlightDto fdto3 = new FlightDto(FDate, FAnum, FFName, FLeave, FLeaveDate, FArrive, FArriveDate, FGate);
		
		int fres = fservice.FlightUpdate(fdto3);
		
		request.setAttribute("filghtUpdate" ,fres);
		request.getRequestDispatcher("/FlightAll.jsp").forward(request, response);;
		
		
	}

	/**
	 * <pre>
	 * 운항정보 수정시 전체 출력 창
	 * </pre>
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void FlightUpView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int upNum = Integer.parseInt(request.getParameter("updateNum"));
		
		FlightDto result = fservice.FlightUpView(upNum);
	
		request.setAttribute("flightUpView", result);
		request.getRequestDispatcher("/FlightUpdate.jsp").forward(request, response);
	
	
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("action = "+action);
		
		
		switch(action) {
		case "flightSelect" : 
			FlightSelect(request, response); 
			break;
		case "flightWrite" :
			FlightWrite(request, response);
			break;
		case "airplaneCall" :
			FlightCall(request, response);
			break;
		case "airplaneAll" : 
			FlightAll(request,response);
			break;
		case "airplaneAll2" :
			FlightAll2(request,response);
			break;
		case "flightUpdate" :
			FlightUpdate(request,response);
			break;
		case "flightUpView" :
			FlightUpView(request,response);
			break;
	
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
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}
}
