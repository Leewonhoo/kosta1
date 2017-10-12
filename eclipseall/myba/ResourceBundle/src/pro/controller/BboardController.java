package pro.controller;

import java.util.ArrayList;

import pro.model.dto.Bboard;
import pro.model.dto.Bmember;
import pro.model.service.BboardService;

public class BboardController {
	private BboardService bbs = new BboardService();
	
	/**
	 * <pre>
	 * 닉네임 확인
	 * </pre>
	 * @param id
	 * @param nick
	 * @return 사용가능 : true, 아니면 false
	 */
	public boolean nickcheck(String id, String nick) {
		if ((nick.length() > 10) || (nick.length() < 2) || (nick == null)) {
			System.out.println("닉네임을 2자리이상 10자리 이하로 입력하세요.");
			return false;
		}
		if (!bbs.nickcheck(id, nick)) {
			System.out.println("중복된 닉네임이 있습니다.");
			return false;
		} else {
			System.out.println("닉네임 사용이 가능합니다.");
			return true;
		}
	}
	
	/**
	 * <pre>
	 * 게시글 등록
	 * </pre>
	 * @param Dto
	 * @return 등록 : true, 실패 : false
	 */
	public String boardinsert(Bboard Dto) {
		if ((Dto.getbId() == null) || (Dto.getbNick() == null) || (Dto.getbTitle() == null) || (Dto.getbPw() == null)
				|| (Dto.getbId().length() < 1) || (Dto.getbNick().length() < 1) || (Dto.getbTitle().length() < 1) || (Dto.getbPw().length() < 0)) {
			return "값을  입력해주세요.";
		}
		if ((Dto.getbPw().length() > 10) || (Dto.getbTitle().length() > 25) || (Dto.getbTag().length() > 250) || (Dto.getbMemo().length() > 500)) {
			return "글자 수를 초과하였습니다.";
		}
		if (bbs.bboardAdd(Dto) == 1) {
			return "게시글 등록이 완료되었습니다.";
		} else {
			return "게시글 등록이 실패되었습니다.";
		}
	}
	
	/**
	 * <pre>
	 * 게시글 삭제
	 * </pre>
	 * @param Dto
	 * @return 삭제 : true. 실패 : false
	 */
	public String boarddelete(Bboard Dto) {
		if ((Dto.getbNick() == null) || (Dto.getbPw() == null) || (Dto.getbNum() < 1)) {
			return "값을 입력해주세요.";
		}
		if (bbs.bboardDelete(Dto) == 1) {
			return "게시글 삭제가 완료되었습니다.";
		} else {
			return "게시글 삭제에 실패하였습니다.";
		}
	}
	
	/**
	 * <pre>
	 * 개인정보 조회
	 * </pre>
	 * @param Dto
	 * @return 개인정보
	 */
	public String bmeminfor(Bboard Dto) {
		String str = bbs.bmemberinfor(Dto);
		if (str != null) {
			return str;
		}
		return "정보를 불러오는데 실패하였습니다.";
	}
	
	/**
	 * <pre>
	 * 회원 정보 변경
	 * </pre>
	 * @param Dto
	 * @return 정보변경 / 실패
	 */
	public String bmemupdate(Bmember Dto) {
		if ((Dto.getmPw() == null) || (Dto.getmNick() == null) || (Dto.getmBirth() == null) ||
				(Dto.getmGender() == null) || (Dto.getmAnswer() == null)) {
			return "필수 항목을 입력해주세요.";
		}
		if ((Dto.getmPw().length() > 10) || (Dto.getmNick().length() > 10) || (Dto.getmGender().length() > 1)
				|| (Dto.getmAnswer().length() > 25)) {
			return "글자 수를 초과하였습니다.";
		}
		if (bbs.bmemupdate(Dto) == 1) {
			return "정보가 변경되었습니다.";
		}
		return "정보 변경에 실패하였습니다.";
	}

	/**
	 * <pre>
	 * 게시판 불러오기
	 * </pre>
	 * @param num
	 * @return 불러오기 / null값
	 */
	public ArrayList boardselectAll(int num) {
		ArrayList al;
		al = bbs.bboardSelectAll(num);
		if (al == null) {
			return null;
		}
		return al;
	}
	
	/**
	 * <pre>
	 * 자기가 입력한 게시판
	 * </pre>
	 * @param num
	 * @param nick
	 * @return 
	 */
	public ArrayList boardselectmy(int num, String nick) {
		ArrayList al = null;
		al = bbs.bboardSelectmy(num, nick);
		if (al == null) {
			return null;
		}
		return al;
	}
	
	/**
	 * <pre>
	 * 게시판 마지막 인덱스
	 * </pre>
	 * @return 마지막 번호
	 */
	public int boardLast() {
		return bbs.bboardLast();
	}
	
	/**
	 * <pre>
	 * 게시판 세부내용
	 * </pre>
	 * @param num
	 * @return 세부내용
	 */
	public ArrayList bbetail(int num) {
		ArrayList al = null;
		al = bbs.bbetail(num);
		if (al == null) {
			return null;
		}
		return al;
	}
	
	/**
	 * <pre>
	 * 조횟수 증가
	 * </pre>
	 * @param num
	 * @return 성공 : 조회업, 실패 : 조회업 실패
	 */
	public String bvisitup(int num) {
		if (bbs.bvisitup(num)) {
			return "조회 업!!";
		}
		return "조회 업 실패 ㅠㅠ";
	}
	
	/**
	 * <pre>
	 * 닉네임 변경시 게시글 닉네임 변경
	 * </pre>
	 * @param Dto
	 * @return 성공: 변경완료, 실패: 변경실패
	 */
	public String bnickupdate(String id, String nick) {
		if (bbs.bnickupdate(id, nick) == 1) {
			return "게시글 변경 완료!!";
		}
		return "게시글 변경 실패 ㅠㅠ";
	}
	
}
