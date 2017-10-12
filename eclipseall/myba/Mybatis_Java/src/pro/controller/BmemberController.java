package pro.controller;

import pro.model.dto.Bmember;
import pro.model.service.BmemberService;

public class BmemberController {
	private BmemberService bs = new BmemberService();
	
	/**
	 * <pre>
	 * 아이디 중복 확인
	 * </pre>
	 * @param id
	 * @return 중복.길이 : false, 사용가능 : true
	 */
	public boolean idcheck(String id) {
		if ((id.length() > 6) || (id.length() < 4) || (id == null)) {
			System.out.println("아이디를 4자리이상 6자리이하로 입력하세요.");
			return false;
		}
		if (bs.idCheck(id)) {
			System.out.println("중복된 아이디가 있습니다.");
			return false;
		} else {
			System.out.println("아이디 사용이 가능합니다.");
			return true;
		}
	}
	
	/**
	 * <pre>
	 * 닉네임 중복 확인
	 * </pre>
	 * @param nick
	 * @return 중복.길이 : false, 사용가능 : true
	 */
	public boolean nickcheck(String nick) {
		if ((nick.length() > 10) || (nick.length() < 2) || (nick == null)) {
			System.out.println("닉네임을 2자리이상 10자리 이하로 입력하세요.");
			return true;
		}
		if (bs.nickcheck(nick)) {
			System.out.println("중복된 닉네임이 있습니다.");
			return true;
		} else {
			System.out.println("닉네임 사용이 가능합니다.");
			return false;
		}
	}
	
	/**
	 * <pre>
	 * 회원가입 조건 확인
	 * </pre>
	 * @param viewDto
	 * @return 회원가입
	 */
	public String memberinsert(Bmember viewDto) {
		if ((viewDto.getmId() == null) || (viewDto.getmPw() == null) || (viewDto.getmName() == null) || (viewDto.getmNick() == null)
				|| (viewDto.getmBirth() == null) || (viewDto.getmGender() == null) || (viewDto.getmAnswer() == null)) {
			return "필수 핳목을 입력해주세요.";
		}
		if ((viewDto.getmId().length() > 6) || (viewDto.getmPw().length() > 10) || (viewDto.getmName().length() > 7)
				|| (viewDto.getmNick().length() > 10) || (viewDto.getmGender().length() > 1) || (viewDto.getmAnswer().length() > 25)) {
			return "글자 수를 초과하였습니다.";
		}
		if (bs.bmemberAdd(viewDto) == 1) {
			return "회원가입이 완료되었습니다.";
		} else {
			return "회원가입이 실패되었습니다.";
		}
	}
	
	/**
	 * <pre>
	 * 회원 탈퇴
	 * </pre>
	 * @param id
	 * @return 탈퇴 / 실패
	 */
	public String memberdelete(String id) {
		if (bs.idCheck(id)) {
			if (bs.bmemberDelete(id) == 1) {
				return "회원 탈퇴되었습니다.";
			}
		}
		return "회원 탈되에 실패되었습니다.";
	}
	
	/**
	 * <pre>
	 * 로그인
	 * </pre>
	 * @param id
	 * @param pw
	 * @return 로그인 / 실패 
	 */
	public String memberlogin(String id, String pw) {
		if ((id.trim() == null) || (pw.trim() == null) || (id.trim().length() < 1) || (pw.trim().length() < 1)) {
			System.out.println("값을 입력하세요.");
			return null;
		}
		String result = bs.bmemberlogin(id, pw);
		if (result != null) {
			System.out.println("로그인 되었습니다.");
			return result;
		}
		System.out.println("로그인에 실패하였습니다.");
		return null;
	}
	
	/**
	 * <pre>
	 * ID 찾기
	 * </pre>
	 * @param dto
	 * @return 찾기 / 실패
	 */
	public String memberid(Bmember dto) {
		if ((dto.getmName() == null) || (dto.getmBirth() == null) || (dto.getmAnswer() == null) || (dto.getmName().length() < 1)
				|| (dto.getmBirth().length() < 1) || (dto.getmAnswer().length() < 1)) {
			System.out.println("값을 입력하세요.");
			return null;
		}
		String result = bs.bmemberid(dto);
		if (result != null) {
			return result;
		}
		System.out.println("일치하는 정보가 없습니다.");
		return null;
	}
	
	/**
	 * <pre>
	 * PW 찾기
	 * </pre>
	 * @param dto
	 * @return 성공 / 실패
	 */
	public String memberpw(Bmember dto) {
		if ((dto.getmId() == null) || (dto.getmName() == null) || (dto.getmBirth() == null) || (dto.getmAnswer() == null) ||
				(dto.getmId().length()  < 1) ||(dto.getmName().length() < 1) || (dto.getmBirth().length() < 1) || (dto.getmAnswer().length() < 1)) {
			System.out.println("값을 입력하세요.");
			return null;
		}
		String result = bs.bmemberpw(dto);
		if (result != null) {
			return result;
		}
		System.out.println("일치하는 정보가 없습니다.");
		return null;
	}
	
}
