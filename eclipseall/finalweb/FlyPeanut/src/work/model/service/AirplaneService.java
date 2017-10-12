package work.model.service;

import java.util.ArrayList;

import work.model.dao.AirplaneDao;
import work.model.dto.AirplaneDto;

public class AirplaneService {
	
	private static AirplaneDao adao = AirplaneDao.getInstance();

	public int addAirplane(AirplaneDto adto) {
		return adao.addAirplane(adto);
	}

	public ArrayList<AirplaneDto> selectTitle(AirplaneDto adto) {
		return adao.selectTitle(adto);
	}

	public AirplaneDto viewAirplane(int airNum) {
		return adao.viewAirplane(airNum);
	}

}
