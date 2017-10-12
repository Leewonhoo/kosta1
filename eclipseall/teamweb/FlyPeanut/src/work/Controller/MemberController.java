package work.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import work.Dto.MemberDto;
import work.Service.MemberService;

/**
 * Servlet implementation class MemberController
 */
public class MemberController extends HttpServlet {
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
		case "m_login": login(request, response);
			break;
		case "m_logout": logout(request, response);
			break;
		case "m_check": idCheck(request,response);
			break;
		case "m_insert": memberInsert(request, response);
			break;
		case "pw_infor": myInformation(request, response);
			break;
		case "b_modify": inforUpdate(request, response);
			break;
		case "b_delete": delete(request, response);
			break;
		case "re_pass": rePass(request, response);
			break;
		case "m_id": serarchId(request, response);
			break;
		case "m_pw": serarchPw(request, response);
			break;
		default:
			System.out.println("Error!");
		}
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberService memberS = new MemberService();
		String id = request.getParameter("m_id");
		String pw = request.getParameter("m_pw");
		String result = memberS.login(id, pw);
		if (result != null) {
			session.setAttribute("userId", result);
		}
		response.sendRedirect("Login.jsp");
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		session.removeAttribute("userId");
		session.invalidate();
		response.sendRedirect("Login.jsp");
	}
	
	private void idCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService memberS = new MemberService();
		if (memberS.idCheck(request.getParameter("m_id"))) {
			request.setAttribute("input", request.getParameter("m_id"));
			request.setAttribute("idcheck", true);
		} else {
			request.setAttribute("input", request.getParameter("m_id"));
			request.setAttribute("idcheck", false);
		}
		request.getRequestDispatcher("/Idcheck.jsp").forward(request, response);
	}
	
	private void memberInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService memberS = new MemberService();
		MemberDto mem = new MemberDto();
		mem.setId(request.getParameter("m_id"));
		mem.setPw(request.getParameter("m_pw"));
		mem.setkName(request.getParameter("m_kname"));
		mem.seteLastName(request.getParameter("m_eFamily"));
		mem.seteFristName(request.getParameter("m_eName"));
		mem.setSex(request.getParameter("m_sex"));
		mem.setNation(request.getParameter("m_nation"));
		mem.setBirth(request.getParameter("m_year")+"/"+request.getParameter("m_month")+"/"+request.getParameter("m_day"));
		mem.setMobile(request.getParameter("m_mobile1")+"-"+request.getParameter("m_mobile2")+"-"+request.getParameter("m_mobile3"));
		mem.setEmail(request.getParameter("m_email")+"@"+request.getParameter("m_domain1"));
		mem.setSms(request.getParameter("m_sms"));
		mem.seteCheck(request.getParameter("m_echeck"));
		if (memberS.insert(mem) == 1) {
			request.setAttribute("message", "회원가입이 완료되었습니다.");
		} else {
			request.setAttribute("message", "회원가입에 실패하였습니다.");
		}
		request.getRequestDispatcher("/Login.jsp").forward(request, response);
	}
	
	private void myInformation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		MemberService memberS = new MemberService();
		String id = (String)session.getAttribute("userId");
		String pw = request.getParameter("check_pw");
		MemberDto dto = memberS.myInfor(id, pw);
		if (dto != null) {
			request.setAttribute("myinfor", dto);
			request.getRequestDispatcher("/Myinfor.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "비밀번호를 확인해주세요");
			request.getRequestDispatcher("/Passcheck.jsp").forward(request, response);
		}
	}
	
	private void inforUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		MemberService memberS = new MemberService();
		MemberDto mem = new MemberDto();
		mem.setId((String)session.getAttribute("userId"));
		mem.setPw(request.getParameter("modi_Pw"));
		mem.setNation(request.getParameter("modi_Nation"));
		mem.setMobile(request.getParameter("modi_Mobile1")+"-"+request.getParameter("modi_Mobile2")+"-"+request.getParameter("modi_Mobile3"));
		mem.setEmail(request.getParameter("modi_Email")+"@"+request.getParameter("modi_Domain1"));
		mem.setSms(request.getParameter("modi_Sms"));
		mem.seteCheck(request.getParameter("modi_Echeck"));
		mem.setAddress(request.getParameter("modi_Post")+"|"+request.getParameter("modi_Add1")+"|"+request.getParameter("modi_Add2"));
		
		MemberDto dto = memberS.inforUpdate(mem);
		if (dto != null) {
			request.setAttribute("myinfor", dto);
			request.getRequestDispatcher("/Myinfor.jsp").forward(request, response);
		} else {
			request.setAttribute("myinfor", dto);
			request.getRequestDispatcher("/Myinfor.jsp").forward(request, response);
		}
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		MemberService memberS = new MemberService();
		int result = memberS.delete((String)session.getAttribute("userId"));
		if (result == 1) {
			session.removeAttribute("userId");
			session.invalidate();
			request.setAttribute("message", "회원 탈퇴 처리 되었습니다.");
		} else {
			request.setAttribute("message", "회원 탈퇴에 실패하였습니다.");
		}
		request.getRequestDispatcher("/Login.jsp").forward(request, response);
	}
	
	private void rePass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		MemberService memberS = new MemberService();
		int result = memberS.repass((String)session.getAttribute("userId"), request.getParameter("gu_pw"), request.getParameter("new_pw"));
		if (result == 1) {
			request.setAttribute("message", "비밀번호 변경이 처리 되었습니다.");
		} else {
			request.setAttribute("message", "비밀번호 변경에 실패하였습니다.");
		}
		request.getRequestDispatcher("/Login.jsp").forward(request, response);
	}
	
	private void serarchId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService memberS = new MemberService();
		String mobile = request.getParameter("mobile_search1")+"-"+request.getParameter("mobile_search2")+"-"+request.getParameter("mobile_search3");
		String id = memberS.selectId(request.getParameter("name_search"), mobile);
		if (id != null) {
			request.setAttribute("selectId", "조회 결과 => "+id);
		} else {
			request.setAttribute("selectId", "일치하는 정보가 없습니다.");
		}
		request.getRequestDispatcher("/Idsearch.jsp").forward(request, response);
	}
	
	private void serarchPw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService memberS = new MemberService();
		String mobile = request.getParameter("mobile_search1")+"-"+request.getParameter("mobile_search2")+"-"+request.getParameter("mobile_search3");
		String pw = memberS.selectPw(request.getParameter("id_search"), request.getParameter("name_search"), mobile);
		if (pw != null) {
			request.setAttribute("selectPw", "임시 비밀번호 발급 => "+pw);
		} else {
			request.setAttribute("selectPw", "일치하는 정보가 없습니다.");
		}
		request.getRequestDispatcher("/Pwsearch.jsp").forward(request, response);
	}

}
