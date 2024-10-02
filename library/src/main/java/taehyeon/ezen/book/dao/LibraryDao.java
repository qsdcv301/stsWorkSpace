package taehyeon.ezen.book.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import taehyeon.ezen.book.dto.LibraryDto;


@Repository
public interface LibraryDao {
	int insertLibrary(LibraryDto dto);

	int updateLibrary(LibraryDto dto);

	int deleteLibrary(int id);

	int getTotalLibraryCount();

	List<LibraryDto> listLibrary(int limit, int recordsPerPage);

	LibraryDto viewLibrary(int num);

	int selectBookTitle(String bookTitle, int num);

	int getSearchLibraryCount(String searchKey, String searchVal);

	List<LibraryDto> listSearchLibrary(String searchKey, String searchVal, int limit, int recordsPerPage);
}
