package work.model.service;

import java.util.ArrayList;

import work.model.dao.BlogDao;
import work.model.dto.Blogin;

public class BlogService {
	private BlogDao blogdao = BlogDao.getInstance();
	
	/**
	 * <pre>
	 * �α� ���� �Է�
	 * </pre>
	 * @param id
	 * @return �Է� ���
	 */
	public int loginmemo(String id) {
		return blogdao.insert(id);
	}
	
	/**
	 * <pre>
	 * �α� ���� ������Ʈ
	 * </pre>
	 * @param status
	 * @param id
	 * @return ������Ʈ ���
	 */
	public int updatememo(String status, String id) {
		return blogdao.loupdate(status, id);
	}
	
	/**
	 * <pre>
	 * �α� ������ ���
	 * </pre>
	 */
	public ArrayList lastmemo(Blogin Dto) {
		return null;
	}
	
}
