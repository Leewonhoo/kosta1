package work.model.service;

import work.model.dao.MemberDao;
import work.model.dto.MemberDto;

public class MemberService {
	MemberDao memDao = MemberDao.getInstance();
	
	public boolean idCheck(String id) {
		return memDao.isM_id(id);
	}
	
	public int insert(MemberDto dao) {
		return memDao.insert(dao);
	}
	
	public String login(String id, String pw) {
		return memDao.login(id, pw);
	}
	
	public MemberDto myInfor(String id, String pw) {
		return memDao.myInfor(id, pw);
	}
	
	public MemberDto inforUpdate(MemberDto dto) {
		int result = memDao.inforUpdate(dto);
		if (result == 1) {
			return memDao.myInfor(dto.getId(), dto.getPw());
		}
		return memDao.myInfor(dto.getId(), dto.getPw());
	}
	
	public int delete(String id) {
		return memDao.delete(id);
	}
	
	public int repass(String id, String guPw, String newPw) {
		if (memDao.isM_pw(id, guPw)) {
			return memDao.passUpdate(id, newPw);
		}
		return 0;
	}
	
	public String selectId(String name, String mobile) {
		return memDao.selectId(name, mobile);
	}
	
	public int selectPw(String id, String name, String mobile) {
		if (memDao.selectPw(id, name, mobile)) {
			System.out.println("정보 확인");
			int randoms = 0;
			do {
				randoms = (int)(Math.random()*10000000);
			} while ((randoms <= 99999) || (randoms >= 10000000));
			if (memDao.updatePw(id, randoms) == 1) {
				System.out.println("업뎃");
				return randoms;
			}
		}
		System.out.println("실패");
		return 0;
	}
	
}
