package work.model.service;

import work.model.dao.EmployeeDao;
import work.model.dao.TicketDao;
import work.model.dto.ReservationDto;

public class TicketService {
	private static TicketDao dao = TicketDao.getInstance();
	/**
	 * ¹ßÇàÀü ½Â°´ Á¶È¸
	 * @param rName
	 * @param rNum
	 * @return
	 */
	public String searchIssue(String rName,String rNum) {
		return dao.issueSearch(rName, rNum);
	}
	/**
	 * ¼öÇÏ¹° ¼³Á¤
	 * @param rName
	 * @param tBagNum
	 * @return
	 */
	public String setBagg(String rName,String tBagNum ) {
		return null;
	}
	/**
	 * ¿¹¾àÇÑ ½Â°´ Á¶È¸
	 * @param rName
	 * @param rNum
	 * @return
	 */
	public ReservationDto search(String rName,String rNum) {
		return dao.searchReservation(rName, rNum);
	}
}
