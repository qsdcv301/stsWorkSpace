package taehyeon.ezen.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import taehyeon.ezen.board.dto.BoardDto;


@Service
public interface BoardService {
	int insertBoard(BoardDto dto);

	int updateBoard(BoardDto dto);

	int deleteBoard(int id);

	int getTotalBoardCount();

	List<BoardDto> listBoard(int limit, int recordsPerPage);

	BoardDto viewBoard(int id);

	int selectBookTitle(String title, int id);

	int getSearchBoardCount(String searchKey, String searchVal);

	List<BoardDto> listSearchBoard(String searchKey, String searchVal, int limit, int recordsPerPage);
}
