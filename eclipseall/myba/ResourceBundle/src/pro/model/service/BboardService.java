package pro.model.service;

import java.util.ArrayList;
import java.util.Iterator;

import pro.model.dao.BboardDao;
import pro.model.dto.Bboard;
import pro.model.dto.Bmember;

public class BboardService {
	private BboardDao bbdao = BboardDao.getInstance();
	
	/**
	 * <pre>
	 * 닉네임 확인
	 * </pre>
	 * @param id
	 * @param nick
	 * @return 성공: 아이디, 실패 : null
	 */
	public boolean nickcheck(String id, String nick) {
		String result = bbdao.isM_nick(nick);
		if (id.equals(result)) {
			return true;
		}
		if (result == null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * <pre>
	 * 게시판 작성
	 * </pre>
	 * @param Dto
	 * @return
	 */
	public int bboardAdd(Bboard Dto) {
		return bbdao.insert(Dto);
	}
	
	/**
	 * <pre>
	 * 게시판 삭제
	 * </pre>
	 * @param Dto
	 * @return
	 */
	public int bboardDelete(Bboard Dto) {
		if(bbdao.isB_nick(Dto.getbNick(), Dto.getbNum())) {
			return bbdao.delete(Dto.getbNick(), Dto.getbPw(), Dto.getbNum());
		}
		return 0;
	}
	
	/**
	 * <pre>
	 * 회원 정보 확인
	 * </pre>
	 * @param Dto
	 * @return 회원정보
	 */
	public String bmemberinfor(Bboard Dto) {
		ArrayList al;
		al = bbdao.selectinfor(Dto.getbId(), Dto.getbNick());
		Iterator line = al.iterator();
		line.hasNext();
		String str = line.next().toString();
		String st[] = str.split(",");
		String result = "";
		for (int i = 0; i < st.length; i++) {
			result += (st[i].trim() + ",");
		}
		return result;
	}
	
	/**
	 * <pre>
	 * 회원정보 업데이트
	 * </pre>
	 * @param Dto
	 * @return 업데이트 결과
	 */
	public int bmemupdate(Bmember Dto) {
		return bbdao.bmemupdate(Dto);
	}
	
	/**
	 * <pre>
	 * 게시글 닉네임 변경
	 * </pre>
	 * @param Dto
	 * @return 성공1, 실패0
	 */
	public int bnickupdate(String id, String nick) {
		return bbdao.bnickupdate(id, nick);
	}

	/**
	 * <pre>
	 * 게시판 모든 내용 호출
	 * </pre>
	 * @param num
	 * @return 게시판 정보
	 */
	public ArrayList bboardSelectAll(int num) {
		ArrayList al;
		al = bbdao.selectAll(num);
		if (al.size() > 0) {
			return al;
		}
		return null;
	}
	
	/**
	 * <pre>
	 * 내가 작성한 내용 호출
	 * </pre>
	 * @param num
	 * @param nick
	 * @return 내가 작성한 게시판 정보
	 */
	public ArrayList bboardSelectmy(int num, String nick) {
		ArrayList al;
		al = bbdao.selectmy(num, nick);
		if (al.size() > 0) {
			return al;
		}
		return null;
	}
	
	/**
	 * <pre>
	 * 게시판 마지막 번호
	 * </pre>
	 * @return 게시판 마지막 번호
	 */
	public int bboardLast() {
		return bbdao.selectLast();
	}
	
	/**
	 * <pre>
	 * 게시판 세부사항
	 * </pre>
	 * @param num
	 * @return 선택한 게시판 세부정보
	 */
	public ArrayList bbetail(int num) {
		if (bbdao.isB_num(num)) {
			return bbdao.bdeatil(num);
		}
		return null;
	}
	
	/**
	 * <pre>
	 * 조회수 증가
	 * </pre>
	 * @param num
	 * @return 성공 true 실패 false
	 */
	public boolean bvisitup(int num) {
		if (bbdao.bborupdate(num) == 1) {
			return true;
		}
		return false;
	}
	
}
