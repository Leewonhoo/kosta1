package work.model.service;

import java.util.ArrayList;

import work.model.dao.NoticeDao;
import work.model.dto.NoticeDto;

public class NoticeService {
	
	private static NoticeDao ndao = NoticeDao.getInstance();

	public ArrayList<NoticeDto> selectAll(NoticeDto ndto) {
		return ndao.selectAll(ndto);
	}

	public NoticeDto seeNotice(int noticeNum) {
		System.out.println(noticeNum);
		return ndao.noticeView(noticeNum);
	}

	public int writeNotice(String title, String contents) {
		return ndao.writeNotice(title,contents);
	}

}
