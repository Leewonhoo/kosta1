package controller;

import work.model.dto.Blogin;
import work.model.service.BlogService;

public class BlogController {
	private BlogService bls = new BlogService();
	
	/**
	 * <pre>
	 * ���̵� ����
	 * </pre>
	 * @param id
	 * @return �α����̺� ����
	 */
	public String loginsert(String id) {
		if ((id == null) || (id.length() < 1)) {
			return "�ʼ� �׸��� �Է����ּ���.";
		}
		if (id.length() > 6) {
			return "���� ���� �ʰ��Ͽ����ϴ�.";
		}
		if (bls.loginmemo(id) == 1) {
			return "�α� ������ �Ϸ�Ǿ����ϴ�.";
		} else {
			return "�α� ������ ���еǾ����ϴ�.";
		}
	}
	
	/**
	 * <pre>
	 * �α׾ƿ��� ������Ʈ
	 * </pre>
	 * @param status
	 * @param id
	 * @return �α� ������Ʈ
	 */
	public String logupdate(String status, String id) {
		if ((id == null) || (id.length() < 1)) {
			return "�ʼ� �׸��� �Է����ּ���.";
		}
		if (id.length() > 6) {
			return "���� ���� �ʰ��Ͽ����ϴ�.";
		}
		if (bls.updatememo(status, id) == 1) {
			return "�α� ������ �Ϸ�Ǿ����ϴ�.";
		} else {
			return "�α� ������ ���еǾ����ϴ�.";
		}
	}
}
