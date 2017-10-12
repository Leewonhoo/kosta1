package work.model.service;

import java.util.HashMap;

import work.model.dao.AddressDao;
import work.model.dto.AddressDto;

public class AddressService {
	AddressDao addDao = AddressDao.getInstance();
	
	/**
	 * <pre>페이징 처리를 위한 전체 글 개수</pre>
	 * @param road
	 * @return
	 */
	public int allNum(String road) {
		return addDao.AllPost(road);
	}
	
	/**
	 * <pre>우편번호 검색(도로명)</pre>
	 * @param road
	 * @return
	 */
	public HashMap<Integer, AddressDto> search(String road) {
		return addDao.searchPost(road);
	}
	
}
