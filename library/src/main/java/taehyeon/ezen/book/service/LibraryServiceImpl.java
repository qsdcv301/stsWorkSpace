package taehyeon.ezen.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import taehyeon.ezen.book.dao.LibraryDao;
import taehyeon.ezen.book.dto.LibraryDto;

@Service
public class LibraryServiceImpl implements LibraryService {

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
    public List<LibraryDto> listLibrary() {
        return dao.listLibrary();
    }

    @Override
    public LibraryDto viewLibrary(int id) {
        return dao.viewLibrary(id);
    }

}
