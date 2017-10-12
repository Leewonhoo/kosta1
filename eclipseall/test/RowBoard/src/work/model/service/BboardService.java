package work.model.service;

import java.util.HashMap;

import work.model.dao.BboardDao;
import work.model.dto.Bboard;

public class BboardService {
	private BboardDao bbdao = BboardDao.getInstance();

	/**
	 * <pre>
	 * 전체목록 조회
	 * </pre>
	 * @param num
	 * @return �Խ��� ����
	 */
	public HashMap<Integer, Bboard> bboardSelectAll(int num, int page) {
		return bbdao.selectAll(num, page);
	}
	
	/**
	 * <pre>
	 * 전체 개수 조회
	 * </pre>
	 * @return 총 개수
	 */
	public int bboardLast() {
		return bbdao.selectLast();
	}
	
}
