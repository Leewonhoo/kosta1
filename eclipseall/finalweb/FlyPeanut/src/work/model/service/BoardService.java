package work.model.service;

import java.util.HashMap;

import work.model.dao.BoardDao;
import work.model.dto.BoardDto;
import work.model.dto.ReplyDto;

public class BoardService {
	BoardDao boardDao = BoardDao.getInstance();
	
	/**
	 * <pre>게시글 등록</pre>
	 * @param dto
	 * @return
	 */
	public int insert(BoardDto dto) {
		if (dto.getbNum() == 0) {
			return boardDao.insert(dto);
		} else {
			return boardDao.update(dto);
		}
	}
	
	/**
	 * <pre>내가 쓴 글 목록 조회</pre>
	 * @param id
	 * @return
	 */
	public HashMap<Integer, BoardDto> myList(String id){
		return boardDao.myList(id);
	}
	
	/**
	 * <pre>게시글 상세 조회</pre>
	 * @param number
	 * @return
	 */
	public BoardDto detail(int number){
		return boardDao.detail(number);
	}
	
	/**
	 * <pre>답글 조회</pre>
	 * @param number
	 * @return
	 */
	public ReplyDto reply(int number){
		if (boardDao.isrNum(number)) {
			return boardDao.reply(number);
		}
		return null;
	}
	
	/**
	 * <pre>게시글 삭제</pre>
	 * @param number
	 * @return
	 */
	public int delete(int number) {
		if (boardDao.isbNum(number)) {
			return boardDao.delete(number);
		}
		return 0;
	}
	
	/**
	 * <pre>내가 쓴 글 개수</pre>
	 * @param id
	 * @return
	 */
	public double mycount(String id) {
		return boardDao.myCount(id);
	}
	
}
