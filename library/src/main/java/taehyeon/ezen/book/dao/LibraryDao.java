package taehyeon.ezen.book.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import taehyeon.ezen.book.dto.LibraryDto;


@Repository
public interface LibraryDao {
	int insertLibrary(LibraryDto dto);

	int updateLibrary(LibraryDto dto);

	int deleteLibrary(int id);

	List<LibraryDto> listLibrary();

	LibraryDto viewLibrary(int num);
}
