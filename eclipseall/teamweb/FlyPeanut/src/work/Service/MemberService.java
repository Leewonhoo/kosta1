package work.Service;

import work.Dao.MemberDao;
import work.Dto.MemberDto;

public class MemberService {
	MemberDao memDao = MemberDao.getInstance();
	
	/**
	 * <pre>아이디 중복확인</pre>
	 * @param id
	 * @return
	 */
	public boolean idCheck(String id) {
		return memDao.isM_id(id);
	}
	
	/**
	 * <pre>회원가입</pre>
	 * @param dao
	 * @return
	 */
	public int insert(MemberDto dao) {
		return memDao.insert(dao);
	}
	
	/**
	 * <pre>로그인</pre>
	 * @param id
	 * @param pw
	 * @return
	 */
	public String login(String id, String pw) {
		return memDao.login(id, pw);
	}
	
	/**
	 * <pre>내 정보</pre>
	 * @param id
	 * @param pw
	 * @return
	 */
	public MemberDto myInfor(String id, String pw) {
		return memDao.myInfor(id, pw);
	}
	
	/**
	 * <pre>회원 정보 업데이트</pre>
	 * @param dto
	 * @return
	 */
	public MemberDto inforUpdate(MemberDto dto) {
		int result = memDao.inforUpdate(dto);
		if (result == 1) {
			return memDao.myInfor(dto.getId(), dto.getPw());
		}
		return memDao.myInfor(dto.getId(), dto.getPw());
	}
	
	/**
	 * <pre>게시글 삭제</pre>
	 * @param id
	 * @return
	 */
	public int delete(String id) {
		return memDao.delete(id);
	}
	
	/**
	 * <pre>비밀번호 재설정</pre>
	 * @param id
	 * @param guPw
	 * @param newPw
	 * @return
	 */
	public int repass(String id, String guPw, String newPw) {
		if (memDao.isM_pw(id, guPw)) {
			return memDao.passUpdate(id, newPw);
		}
		return 0;
	}
	
	/**
	 * <pre>아이디 찾기</pre>
	 * @param name
	 * @param mobile
	 * @return
	 */
	public String selectId(String name, String mobile) {
		return memDao.selectId(name, mobile);
	}
	
	/**
	 * <pre>비밀번호 찾기</pre>
	 * @param id
	 * @param name
	 * @param mobile
	 * @return
	 */
	public String selectPw(String id, String name, String mobile) {
		String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", 
				"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", 
				"t", "u", "v", "w", "x", "y", "z"};
		if (memDao.selectPw(id, name, mobile)) {
			System.out.println("정보 확인");
			String str = "";
			for(int i=11; i<17; i++) {
				if (i%2 != 0) {
					int randoms = (int)(Math.random()*10);
					str += randoms;
				} else {
					str += alphabet[(int)(Math.random()*26)];
				}
			}
			while (str.length() > 6) {
				
			}
			if (memDao.updatePw(id, str) == 1) {
				return str;
			}
		}
		return null;
	}
	
}
