package pro.controller;

import pro.model.dto.Blogin;
import pro.model.service.BlogService;

public class BlogController {
	private BlogService bls = new BlogService();
	
	/**
	 * <pre>
	 * 아이디 정보
	 * </pre>
	 * @param id
	 * @return 로그테이블 저장
	 */
	public String loginsert(String id) {
		if ((id == null) || (id.length() < 1)) {
			return "필수 항목을 입력해주세요.";
		}
		if (id.length() > 6) {
			return "글자 수를 초과하였습니다.";
		}
		if (bls.loginmemo(id) == 1) {
			return "로그 저장이 완료되었습니다.";
		} else {
			return "로그 저장이 실패되었습니다.";
		}
	}
	
	/**
	 * <pre>
	 * 로그아웃시 업데이트
	 * </pre>
	 * @param status
	 * @param id
	 * @return 로그 업데이트
	 */
	public String logupdate(String status, String id) {
		if ((id == null) || (id.length() < 1)) {
			return "필수 항목을 입력해주세요.";
		}
		if (id.length() > 6) {
			return "글자 수를 초과하였습니다.";
		}
		if (bls.updatememo(status, id) == 1) {
			return "로그 수정이 완료되었습니다.";
		} else {
			return "로그 수정이 실패되었습니다.";
		}
	}
}
