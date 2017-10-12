package work.Service;

import java.util.HashMap;

import work.Dao.AddressDao;
import work.Dto.AddressDto;

public class AddressService {
	AddressDao addDao = AddressDao.getInstance();
	
	public int allNum(String road) {
		return addDao.AllPost(road);
	}
	
	public HashMap<Integer, AddressDto> search(String road) {
		return addDao.searchPost(road);
	}
	
}
