package taehyeon.ezen.book.controller;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import taehyeon.ezen.book.dto.LibraryDto;
import taehyeon.ezen.book.service.LibraryService;
import taehyeon.ezen.book.util.Paging;

@Controller
public class BookController {

	@Autowired
	private LibraryService libraryService;

	LibraryDto libraryDto;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@RequestParam(value = "id", required = false) Integer id,
					   @RequestParam(value = "pg", required = false, defaultValue = "1") int currentPage,
					   @RequestParam(value = "searchKey", required = false, defaultValue = "title") String searchKey,
					   @RequestParam(value = "searchVal", required = false) String searchVal, Model model) {
		int recordsPerPage = 10;
		int pagesPerGroup = 10;
		int totalRecords;
		List<LibraryDto> libraryDtoList;

		if (searchKey != null && searchVal != null && !searchVal.isEmpty()) {
			totalRecords = libraryService.getSearchLibraryCount(searchKey, searchVal);
			libraryDtoList = libraryService.listSearchLibrary(searchKey, searchVal, (currentPage - 1) * recordsPerPage,
					recordsPerPage);
		} else {
			totalRecords = libraryService.getTotalLibraryCount();
			libraryDtoList = libraryService.listLibrary((currentPage - 1) * recordsPerPage, recordsPerPage);
		}

		Paging paging = new Paging(totalRecords, recordsPerPage, currentPage, pagesPerGroup);

		model.addAttribute("paging", paging);
		model.addAttribute("library", libraryDtoList);
		model.addAttribute("encodeSearchKey", URLEncoder.encode(searchKey, StandardCharsets.UTF_8));
		model.addAttribute("encodeSearchVal",
				URLEncoder.encode(searchVal != null ? searchVal : "", StandardCharsets.UTF_8));
		return "home";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam(value = "id", required = false) int id,
					   @RequestParam(value = "pg", required = false, defaultValue = "1") int currentPage,
					   @RequestParam(value = "searchKey", required = false, defaultValue = "title") String searchKey,
					   @RequestParam(value = "searchVal", required = false) String searchVal, Model model) {

		libraryDto = libraryService.viewLibrary(id);
		model.addAttribute("boardView", libraryDto);
		return "edit";
	}

	@GetMapping("/write")
	public String write(Model model) {
		return "write";
	}

	@GetMapping("/view")
	public String view(@RequestParam(value = "id", required = false) int id,
					   @RequestParam(value = "pg", required = false, defaultValue = "1") int currentPage,
					   @RequestParam(value = "searchKey", required = false, defaultValue = "title") String searchKey,
					   @RequestParam(value = "searchVal", required = false) String searchVal, Model model) {
		libraryDto = libraryService.viewLibrary(id);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("boardView", libraryDto);
		return "view";
	}

	@PostMapping("/write")
	public String postWrite(LibraryDto libraryDto){
		libraryService.insertLibrary(libraryDto);
		return "redirect:/";
	}

	@PostMapping("/edit")
	public String postEdit(LibraryDto libraryDto){
		libraryService.updateLibrary(libraryDto);
	return "redirect:/";
	}

	@GetMapping("/del")
	public String Del(@RequestParam("id") int id){
		libraryService.deleteLibrary(id);
		return "redirect:/";
	}
}
