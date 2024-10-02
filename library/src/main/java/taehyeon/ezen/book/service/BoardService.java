package taehyeon.ezen.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import taehyeon.ezen.book.dto.BoardDto;


@Service
public interface BoardService {
	int insertBoard(BoardDto dto);

	int updateBoard(BoardDto dto);

	int updateCount(long num);

	int deleteBoard(long num);

	int getTotalBoardCount();

	List<BoardDto> listBoard(int limit, int recordsPerPage);

	BoardDto viewBoard(long num);

	int selectUserId(String userid, int num);

	int isPass(long num, String pass);

	int getSearchBoardCount(String searchKey, String searchVal);

	List<BoardDto> listSearchBoard(String searchKey, String searchVal, int limit, int recordsPerPage);
}
