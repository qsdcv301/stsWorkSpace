package taehyeon.com.kdtweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import taehyeon.com.kdtweb.model.BoardDto;

@Repository
public interface BoardDao {
	int insertBoard(BoardDto dto);

	int updateBoard(BoardDto dto);

	int updateCount(long num); // 카운트 업데이트 updateBoard()메소드 오버로드

	int deleteBoard(long num);

	int getTotalBoardCount(); // 전체 개시글 수를 가져옴

	List<BoardDto> listBoard(int limit, int recordsPerPage);

	BoardDto viewBoard(long num);

	int selectUserId(String userid, int num);

	int isPass(long num, String pass);

	int getSearchBoardCount(String searchKey, String searchVal);

	List<BoardDto> listSearchBoard(String searchKey, String searchVal, int limit, int recordsPerPage);
}
