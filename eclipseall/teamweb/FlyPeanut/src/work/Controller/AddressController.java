package work.Controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import work.Dto.AddressDto;
import work.Service.AddressService;

/**
 * Servlet implementation class AddressController
 */
public class AddressController extends HttpServlet {

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
		switch(action) {
		case "searchPost": searchPost(request, response);
			break;
		}
	}

	private void searchPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddressService addressS = new AddressService();
		if (request.getParameter("dong") != null) {
			int count = addressS.allNum(request.getParameter("dong"));
			HashMap<Integer, AddressDto> hash = addressS.search(request.getParameter("dong"));
			request.setAttribute("selectpost", hash);
		} else {
			request.setAttribute("selectpost", null);
		}
		request.getRequestDispatcher("/Address.jsp").forward(request, response);
	}

}
