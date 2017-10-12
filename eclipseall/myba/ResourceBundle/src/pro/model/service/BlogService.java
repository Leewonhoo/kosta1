package pro.model.service;

import java.util.ArrayList;

import pro.model.dao.BlogDao;
import pro.model.dto.Blogin;

public class BlogService {
	private BlogDao blogdao = BlogDao.getInstance();
	
	/**
	 * <pre>
	 * 로그 정보 입력
	 * </pre>
	 * @param id
	 * @return 입력 결과
	 */
	public int loginmemo(String id) {
		return blogdao.insert(id);
	}
	
	/**
	 * <pre>
	 * 로그 정보 업데이트
	 * </pre>
	 * @param status
	 * @param id
	 * @return 업데이트 결과
	 */
	public int updatememo(String status, String id) {
		return blogdao.loupdate(status, id);
	}
	
	/**
	 * <pre>
	 * 로그 마지막 기록
	 * </pre>
	 */
	public ArrayList lastmemo(Blogin Dto) {
		return null;
	}
	
}
