package taehyeon.ezen.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import taehyeon.ezen.board.dao.BoardDao;
import taehyeon.ezen.board.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDao dao;

    @Override
    public int insertBoard(BoardDto dto) {
        return dao.insertBoard(dto);
    }

    @Override
    public int updateBoard(BoardDto dto) {
        return dao.updateBoard(dto);
    }

    @Override
    public int deleteBoard(long num) {
        return dao.deleteBoard(num);
    }

    @Override
    public int getTotalBoardCount() {
        return dao.getTotalBoardCount();
    }

    @Override
    public List<BoardDto> listBoard(int limit, int recordsPerPage) {
        return dao.listBoard(limit, recordsPerPage);
    }

    @Override
    public BoardDto viewBoard(long num) {
        return dao.viewBoard(num);
    }

    @Override
    public int selectBookTitle(String title, long num) {
        return dao.selectBoardTitle(title, num);
    }

    @Override
    public int getSearchBoardCount(String searchKey, String searchVal) {
        return dao.getSearchBoardCount(searchKey, searchVal);
    }

    @Override
    public List<BoardDto> listSearchBoard(String searchKey, String searchVal, int limit, int recordsPerPage) {
        return dao.listSearchBoard(searchKey, searchVal, limit, recordsPerPage);
    }

}
