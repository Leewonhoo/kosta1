package work.model.service;

import java.util.ArrayList;

import work.model.dao.FlightDao;
import work.model.dto.FlightDto;

public class FlightService {

	private static FlightDao fdao = FlightDao.getInstance();
	
	public ArrayList<FlightDto> FlightSelect(String leave, String arrive) {
		
		return fdao.FlightSelect(leave,arrive);
	}

	public int FlightWrite(FlightDto fdto) {
		return fdao.FlightWrite(fdto);
	}

	public ArrayList<FlightDto> FlightAll(FlightDto fdto1) {
		return fdao.FlightAll(fdto1);
	}

	public FlightDto FlightUpView(int upNum) {
		return fdao.FlightUpView(upNum);
	}

	public int FlightUpdate(FlightDto fdto3) {
		return fdao.FlightUpdate(fdto3);
	}
	
	/**
	 * <pre>선택한 운항일지 조회</pre>
	 * @param flight
	 * @param arrive
	 * @return
	 */
	public ArrayList<FlightDto> selectFlight(String flight, String arrive){
	      return fdao.selectFlight(flight, arrive);
	  }

}
