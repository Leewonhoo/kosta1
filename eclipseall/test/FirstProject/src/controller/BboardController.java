package controller;

import java.util.ArrayList;

import work.model.dto.Bboard;
import work.model.dto.Bmember;
import work.model.service.BboardService;

public class BboardController {
	private BboardService bbs = new BboardService();
	
	/**
	 * <pre>
	 * �г��� Ȯ��
	 * </pre>
	 * @param id
	 * @param nick
	 * @return ��밡�� : true, �ƴϸ� false
	 */
	public boolean nickcheck(String id, String nick) {
		if ((nick.length() > 10) || (nick.length() < 2) || (nick == null)) {
			System.out.println("�г����� 2�ڸ��̻� 10�ڸ� ���Ϸ� �Է��ϼ���.");
			return false;
		}
		if (!bbs.nickcheck(id, nick)) {
			System.out.println("�ߺ��� �г����� �ֽ��ϴ�.");
			return false;
		} else {
			System.out.println("�г��� ����� �����մϴ�.");
			return true;
		}
	}
	
	/**
	 * <pre>
	 * �Խñ� ���
	 * </pre>
	 * @param Dto
	 * @return ��� : true, ���� : false
	 */
	public String boardinsert(Bboard Dto) {
		if ((Dto.getbId() == null) || (Dto.getbNick() == null) || (Dto.getbTitle() == null) || (Dto.getbPw() == null)
				|| (Dto.getbId().length() < 1) || (Dto.getbNick().length() < 1) || (Dto.getbTitle().length() < 1) || (Dto.getbPw().length() < 0)) {
			return "����  �Է����ּ���.";
		}
		if ((Dto.getbPw().length() > 10) || (Dto.getbTitle().length() > 25) || (Dto.getbTag().length() > 250) || (Dto.getbMemo().length() > 500)) {
			return "���� ���� �ʰ��Ͽ����ϴ�.";
		}
		if (bbs.bboardAdd(Dto) == 1) {
			return "�Խñ� ����� �Ϸ�Ǿ����ϴ�.";
		} else {
			return "�Խñ� ����� ���еǾ����ϴ�.";
		}
	}
	
	/**
	 * <pre>
	 * �Խñ� ����
	 * </pre>
	 * @param Dto
	 * @return ���� : true. ���� : false
	 */
	public String boarddelete(Bboard Dto) {
		if ((Dto.getbNick() == null) || (Dto.getbPw() == null) || (Dto.getbNum() < 1)) {
			return "���� �Է����ּ���.";
		}
		if (bbs.bboardDelete(Dto) == 1) {
			return "�Խñ� ������ �Ϸ�Ǿ����ϴ�.";
		} else {
			return "�Խñ� ������ �����Ͽ����ϴ�.";
		}
	}
	
	/**
	 * <pre>
	 * �������� ��ȸ
	 * </pre>
	 * @param Dto
	 * @return ��������
	 */
	public String bmeminfor(Bboard Dto) {
		String str = bbs.bmemberinfor(Dto);
		if (str != null) {
			return str;
		}
		return "������ �ҷ����µ� �����Ͽ����ϴ�.";
	}
	
	/**
	 * <pre>
	 * ȸ�� ���� ����
	 * </pre>
	 * @param Dto
	 * @return �������� / ����
	 */
	public String bmemupdate(Bmember Dto) {
		if ((Dto.getmPw() == null) || (Dto.getmNick() == null) || (Dto.getmBirth() == null) ||
				(Dto.getmGender() == null) || (Dto.getmAnswer() == null)) {
			return "�ʼ� �׸��� �Է����ּ���.";
		}
		if ((Dto.getmPw().length() > 10) || (Dto.getmNick().length() > 10) || (Dto.getmGender().length() > 1)
				|| (Dto.getmAnswer().length() > 25)) {
			return "���� ���� �ʰ��Ͽ����ϴ�.";
		}
		if (bbs.bmemupdate(Dto) == 1) {
			return "������ ����Ǿ����ϴ�.";
		}
		return "���� ���濡 �����Ͽ����ϴ�.";
	}

	/**
	 * <pre>
	 * �Խ��� �ҷ�����
	 * </pre>
	 * @param num
	 * @return �ҷ����� / null��
	 */
	public ArrayList boardselectAll(int num, int page) {
		ArrayList al;
		al = bbs.bboardSelectAll(num, page);
		if (al == null) {
			return null;
		}
		return al;
	}
	
	/**
	 * <pre>
	 * �ڱⰡ �Է��� �Խ���
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
	 * �Խ��� ������ �ε���
	 * </pre>
	 * @return ������ ��ȣ
	 */
	public int boardLast() {
		return bbs.bboardLast();
	}
	
	/**
	 * <pre>
	 * �Խ��� ���γ���
	 * </pre>
	 * @param num
	 * @return ���γ���
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
	 * ��Ƚ�� ����
	 * </pre>
	 * @param num
	 * @return ���� : ��ȸ��, ���� : ��ȸ�� ����
	 */
	public String bvisitup(int num) {
		if (bbs.bvisitup(num)) {
			return "��ȸ ��!!";
		}
		return "��ȸ �� ���� �Ф�";
	}
	
	/**
	 * <pre>
	 * �г��� ����� �Խñ� �г��� ����
	 * </pre>
	 * @param Dto
	 * @return ����: ����Ϸ�, ����: �������
	 */
	public String bnickupdate(String id, String nick) {
		if (bbs.bnickupdate(id, nick) == 1) {
			return "�Խñ� ���� �Ϸ�!!";
		}
		return "�Խñ� ���� ���� �Ф�";
	}
	
}
