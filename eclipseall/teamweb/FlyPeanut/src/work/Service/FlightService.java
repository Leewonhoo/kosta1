package work.Service;

import java.util.ArrayList;

import work.Dao.FlightDao;
import work.Dto.FlightDto;

public class FlightService {
	FlightDao flyDao = FlightDao.getInstance();
	
	/**
	 * <pre>������ �������� ��ȸ</pre>
	 * @param flight
	 * @param arrive
	 * @return
	 */
	public ArrayList<FlightDto> selectFlight(String flight, String arrive){
		return flyDao.selectFlight(flight, arrive);
	}
}
