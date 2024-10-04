package taehyeon.ezen.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import taehyeon.ezen.book.dto.LibraryDto;


@Service
public interface LibraryService {
	int insertLibrary(LibraryDto dto);

	int updateLibrary(LibraryDto dto);

	int deleteLibrary(int id);

	List<LibraryDto> listLibrary();

	LibraryDto viewLibrary(int id);

}
