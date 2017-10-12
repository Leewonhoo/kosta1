package controller;

import work.model.dto.Bmember;
import work.model.service.BmemberService;

public class BmemberController {
	private BmemberService bs = new BmemberService();
	
	/**
	 * <pre>
	 * ���̵� �ߺ� Ȯ��
	 * </pre>
	 * @param id
	 * @return �ߺ�.���� : false, ��밡�� : true
	 */
	public boolean idcheck(String id) {
		if ((id.length() > 6) || (id.length() < 4) || (id == null)) {
			System.out.println("���̵� 4�ڸ��̻� 6�ڸ����Ϸ� �Է��ϼ���.");
			return false;
		}
		if (bs.idCheck(id)) {
			System.out.println("�ߺ��� ���̵� �ֽ��ϴ�.");
			return false;
		} else {
			System.out.println("���̵� ����� �����մϴ�.");
			return true;
		}
	}
	
	/**
	 * <pre>
	 * �г��� �ߺ� Ȯ��
	 * </pre>
	 * @param nick
	 * @return �ߺ�.���� : false, ��밡�� : true
	 */
	public boolean nickcheck(String nick) {
		if ((nick.length() > 10) || (nick.length() < 2) || (nick == null)) {
			System.out.println("�г����� 2�ڸ��̻� 10�ڸ� ���Ϸ� �Է��ϼ���.");
			return true;
		}
		if (bs.nickcheck(nick)) {
			System.out.println("�ߺ��� �г����� �ֽ��ϴ�.");
			return true;
		} else {
			System.out.println("�г��� ����� �����մϴ�.");
			return false;
		}
	}
	
	/**
	 * <pre>
	 * ȸ������ ���� Ȯ��
	 * </pre>
	 * @param viewDto
	 * @return ȸ������
	 */
	public String memberinsert(Bmember viewDto) {
		if ((viewDto.getmId() == null) || (viewDto.getmPw() == null) || (viewDto.getmName() == null) || (viewDto.getmNick() == null)
				|| (viewDto.getmBirth() == null) || (viewDto.getmGender() == null) || (viewDto.getmAnswer() == null)) {
			return "�ʼ� �K���� �Է����ּ���.";
		}
		if ((viewDto.getmId().length() > 6) || (viewDto.getmPw().length() > 10) || (viewDto.getmName().length() > 7)
				|| (viewDto.getmNick().length() > 10) || (viewDto.getmGender().length() > 1) || (viewDto.getmAnswer().length() > 25)) {
			return "���� ���� �ʰ��Ͽ����ϴ�.";
		}
		if (bs.bmemberAdd(viewDto) == 1) {
			return "ȸ�������� �Ϸ�Ǿ����ϴ�.";
		} else {
			return "ȸ�������� ���еǾ����ϴ�.";
		}
	}
	
	/**
	 * <pre>
	 * ȸ�� Ż��
	 * </pre>
	 * @param id
	 * @return Ż�� / ����
	 */
	public String memberdelete(String id) {
		if (bs.idCheck(id)) {
			if (bs.bmemberDelete(id) == 1) {
				return "ȸ�� Ż��Ǿ����ϴ�.";
			}
		}
		return "ȸ�� Ż�ǿ� ���еǾ����ϴ�.";
	}
	
	/**
	 * <pre>
	 * �α���
	 * </pre>
	 * @param id
	 * @param pw
	 * @return �α��� / ���� 
	 */
	public String memberlogin(String id, String pw) {
		if ((id.trim() == null) || (pw.trim() == null) || (id.trim().length() < 1) || (pw.trim().length() < 1)) {
			System.out.println("���� �Է��ϼ���.");
			return null;
		}
		String result = bs.bmemberlogin(id, pw);
		if (result != null) {
			System.out.println("�α��� �Ǿ����ϴ�.");
			return result;
		}
		System.out.println("�α��ο� �����Ͽ����ϴ�.");
		return null;
	}
	
	/**
	 * <pre>
	 * ID ã��
	 * </pre>
	 * @param dto
	 * @return ã�� / ����
	 */
	public String memberid(Bmember dto) {
		if ((dto.getmName() == null) || (dto.getmBirth() == null) || (dto.getmAnswer() == null) || (dto.getmName().length() < 1)
				|| (dto.getmBirth().length() < 1) || (dto.getmAnswer().length() < 1)) {
			System.out.println("���� �Է��ϼ���.");
			return null;
		}
		String result = bs.bmemberid(dto);
		if (result != null) {
			return result;
		}
		System.out.println("��ġ�ϴ� ������ �����ϴ�.");
		return null;
	}
	
	/**
	 * <pre>
	 * PW ã��
	 * </pre>
	 * @param dto
	 * @return ���� / ����
	 */
	public String memberpw(Bmember dto) {
		if ((dto.getmId() == null) || (dto.getmName() == null) || (dto.getmBirth() == null) || (dto.getmAnswer() == null) ||
				(dto.getmId().length()  < 1) ||(dto.getmName().length() < 1) || (dto.getmBirth().length() < 1) || (dto.getmAnswer().length() < 1)) {
			System.out.println("���� �Է��ϼ���.");
			return null;
		}
		String result = bs.bmemberpw(dto);
		if (result != null) {
			return result;
		}
		System.out.println("��ġ�ϴ� ������ �����ϴ�.");
		return null;
	}
	
}
