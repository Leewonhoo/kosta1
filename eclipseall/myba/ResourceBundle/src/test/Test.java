package test;

import pro.controller.BboardController;
import pro.controller.BmemberController;
import pro.model.dao.BboardDao;
import pro.model.dao.BmemberDao;
import pro.model.dto.Bboard;
import pro.model.dto.Bmember;
import pro.model.service.BboardService;

public class Test {
	private static BmemberDao  bdao = BmemberDao.getInstance();
	private static BmemberController bc = new BmemberController();
	private static BboardDao  bbdao = BboardDao.getInstance();
	private static BboardService bbs = new BboardService();
	private static BboardController bbc = new BboardController();
	
	public static void main(String[] args) {
		Bmember bmem = new Bmember("idisa7","password8","이원호","leeeea","1981-09-12", "010-1234-6852", "rkdrka@naver.com", "M", "zcvx", 2, "zcvx");
		//bdao.insert(bmem);  //입력
		//bdao.update(bmem);  //수정
		//bdao.delete(bmem.getM_id());  //삭제
		//System.out.println(bdao.isM_id("idisa21"));  //아디 중복
		//System.out.println(bdao.isM_nick("ㄴㄴㄴ"));  //닉 중복
//		HashMap map = bdao.selectlogin("zcvxvzcx");  //로그인
//		Set a = map.keySet();
//		Iterator b = a.iterator();
//		while(b.hasNext()) {
//			String[] mapa = map.get(b.next()).toString().split(",");
//			for(int i=0; i<mapa.length; i++) {
//				System.out.println(mapa[i].trim());
//			}
//		}
//		System.out.println(map.get("idisa1"));
//		System.out.println(bc.memberlogin("idisa1", "password1"));  //로그인확인
		
		//Bboard bb = new Bboard("idisa1", "행주는튼튼", "pw", "title5555", "memo", "");
		Bboard bb = new Bboard();
		bb.setbNick("행주는튼튼");
		bb.setbNum(11);
		bb.setbPw("123");
		//bbdao.insert(bb);
		//System.out.println(bbs.bboardAdd(bb));
		//System.out.println(bbc.boardinsert(bb));
		
		//bbdao.delete("행주는튼튼", "qe", 13);
		//System.out.println(bbs.bboardDelete(bb));
		System.out.println(bbc.boarddelete(bb));
		
		
	}
}
