package taehyeon.ezen.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import taehyeon.ezen.book.dto.LibraryDto;


@Service
public interface BoardService {
	int insertLibrary(LibraryDto dto);

	int updateLibrary(LibraryDto dto);

	int deleteLibrary(int id);

	int getTotalLibraryCount();

	List<LibraryDto> listLibrary(int limit, int recordsPerPage);

	LibraryDto viewLibrary(int id);

	int selectBookTitle(String title, int id);

	int getSearchLibraryCount(String searchKey, String searchVal);

	List<LibraryDto> listSearchLibrary(String searchKey, String searchVal, int limit, int recordsPerPage);
}
