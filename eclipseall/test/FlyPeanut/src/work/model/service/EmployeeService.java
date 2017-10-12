package work.model.service;



import work.model.dao.EmployeeDao;
import work.model.dto.EmployeeDto;

public class EmployeeService {
	private static EmployeeDao dao = EmployeeDao.getInstance();

	public EmployeeService() {
		
	}
	/**
	 * 로그인
	 * @param e_id
	 * @param e_pw
	 * @return
	 */
	public String login(String eId, String ePw) {
		return dao.login(eId, ePw);
	}
	
	/**
	 * 회원가입
	 * @param eId
	 * @param ePw
	 * @param eKname
	 * @param e_efname
	 * @param eElname
	 * @param eSex
	 * @param eBirth
	 * @param eMobile
	 * @param eEmail
	 * @return
	 */
	public int join(String eId,String ePw,String eKname,String e_efname, String eElname,String eSex,String eBirth,String eMobile,String eEmail,String eAddress,String eState) {
		return dao.join(eId, ePw, eKname, e_efname, eElname, eSex, eBirth, eMobile, eEmail,eAddress,eState);
	}
	
	/**
	 * 임시비밀번호로 변경(비밀번호찾기)
	 * @param eId
	 * @param eKname
	 * @param eBirth
	 * @param eEmail
	 * @return
	 */
	public String findPw(String eId, String eKname,String eBirth,String eEmail) {
		return dao.resetPassword(eId, eKname, eBirth, eEmail);
	}
	
	/**
	 * 내정보 조회
	 * @param eId
	 * @return
	 */
	public EmployeeDto myInfo(String eId) {
		return dao.myInfo(eId);
	}
	
	/**
	 * 비밀번호 확인
	 * @param eId
	 * @param ePw
	 * @return
	 */
	public boolean checkPw(String eId,String ePw) {
		return dao.checkPw(eId, ePw);
	}
	
	/**
	 * 비밀번호 변경
	 * @param eId
	 * @param ePw
	 * @return
	 */
	public int resetPw(String eId,String ePw) {
		return dao.updatePassword(eId,ePw);
	}
	
	public int resetInfo(String eId,String eMobile, String Email,String eAddress) {
		return dao.updateInfo(eId, eMobile, Email, eAddress);
	}
	/**
	 * 사번중복조회
	 * @param eId
	 * @return
	 */
	public boolean checkId(String eId) {
		System.out.println("service"+dao.checkId(eId));
		return dao.checkId(eId);
	}
	
	/**
	 * 직원계정삭제
	 * @param eId
	 * @return
	 */
	public boolean delete(String eId) {
		return dao.delete(eId);
	}
}

