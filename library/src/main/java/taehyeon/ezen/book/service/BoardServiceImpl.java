package taehyeon.ezen.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import taehyeon.ezen.book.dao.LibraryDao;
import taehyeon.ezen.book.dto.LibraryDto;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private LibraryDao dao;

    @Override
    public int insertLibrary(LibraryDto dto) {
        return dao.insertLibrary(dto);
    }

    @Override
    public int updateLibrary(LibraryDto dto) {
        return dao.updateLibrary(dto);
    }

    @Override
    public int deleteLibrary(int id) {
        return dao.deleteLibrary(id);
    }

    @Override
    public int getTotalLibraryCount() {
        return dao.getTotalLibraryCount();
    }

    @Override
    public List<LibraryDto> listLibrary(int limit, int recordsPerPage) {
        return dao.listLibrary(limit, recordsPerPage);
    }

    @Override
    public LibraryDto viewLibrary(int id) {
        return dao.viewLibrary(id);
    }

    @Override
    public int selectBookTitle(String title, int id) {
        return dao.selectBookTitle(title, id);
    }

    @Override
    public int getSearchLibraryCount(String searchKey, String searchVal) {
        return dao.getSearchLibraryCount(searchKey, searchVal);
    }

    @Override
    public List<LibraryDto> listSearchLibrary(String searchKey, String searchVal, int limit, int recordsPerPage) {
        return dao.listSearchLibrary(searchKey, searchVal, limit, recordsPerPage);
    }

}
