package work.model.service;

import java.util.HashMap;

import work.model.dao.BoardDao;
import work.model.dto.BoardDto;
import work.model.dto.ReplyDto;

public class BoardService {
	BoardDao boardDao = BoardDao.getInstance();
	
	public int insert(BoardDto dto) {
		if (dto.getbNum() == 0) {
			return boardDao.insert(dto);
		} else {
			return boardDao.update(dto);
		}
	}
	
	public HashMap<Integer, BoardDto> myList(String id){
		return boardDao.myList(id);
	}
	
	public BoardDto detail(int number){
		return boardDao.detail(number);
	}
	
	public ReplyDto reply(int number){
		if (boardDao.isrNum(number)) {
			return boardDao.reply(number);
		}
		return null;
	}
	
	public int delete(int number) {
		if (boardDao.isbNum(number)) {
			System.out.println("삭제");
			return boardDao.delete(number);
		}
		System.out.println("실패");
		return 0;
	}
	
	public double mycount(String id) {
		return boardDao.myCount(id);
	}
}
