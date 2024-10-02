package taehyeon.ezen.board.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import taehyeon.ezen.board.dto.BoardDto;


@Repository
public interface BoardDao {
	int insertBoard(BoardDto dto);

	int updateBoard(BoardDto dto);

	int deleteBoard(long num);

	int getTotalBoardCount();

	List<BoardDto> listBoard(int limit, int recordsPerPage);

	BoardDto viewBoard(long num);

	int selectBoardTitle(String bookTitle, long num);

	int getSearchBoardCount(String searchKey, String searchVal);

	List<BoardDto> listSearchBoard(String searchKey, String searchVal, int limit, int recordsPerPage);
}
