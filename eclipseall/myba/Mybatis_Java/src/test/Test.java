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
		Bmember bmem = new Bmember("idisa7","password8","�̿�ȣ","leeeea","1981-09-12", "010-1234-6852", "rkdrka@naver.com", "M", "zcvx", 2, "zcvx");
		//bdao.insert(bmem);  //�Է�
		//bdao.update(bmem);  //����
		//bdao.delete(bmem.getM_id());  //����
		//System.out.println(bdao.isM_id("idisa21"));  //�Ƶ� �ߺ�
		//System.out.println(bdao.isM_nick("������"));  //�� �ߺ�
//		HashMap map = bdao.selectlogin("zcvxvzcx");  //�α���
//		Set a = map.keySet();
//		Iterator b = a.iterator();
//		while(b.hasNext()) {
//			String[] mapa = map.get(b.next()).toString().split(",");
//			for(int i=0; i<mapa.length; i++) {
//				System.out.println(mapa[i].trim());
//			}
//		}
//		System.out.println(map.get("idisa1"));
//		System.out.println(bc.memberlogin("idisa1", "password1"));  //�α���Ȯ��
		
		//Bboard bb = new Bboard("idisa1", "���ִ�ưư", "pw", "title5555", "memo", "");
		Bboard bb = new Bboard();
		bb.setbNick("���ִ�ưư");
		bb.setbNum(11);
		bb.setbPw("123");
		//bbdao.insert(bb);
		//System.out.println(bbs.bboardAdd(bb));
		//System.out.println(bbc.boardinsert(bb));
		
		//bbdao.delete("���ִ�ưư", "qe", 13);
		//System.out.println(bbs.bboardDelete(bb));
		System.out.println(bbc.boarddelete(bb));
		
		
	}
}
