package taehyeon.ezen.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import taehyeon.ezen.book.dto.LibraryDto;
import taehyeon.ezen.book.service.LibraryService;

@Controller
public class BookController {

	@Autowired
	private LibraryService libraryService;

	LibraryDto libraryDto;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@RequestParam(value = "id", required = false) Integer id, Model model) {

		List<LibraryDto> libraryDtoList;
		libraryDtoList = libraryService.listLibrary();
		model.addAttribute("library", libraryDtoList);
		return "home";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam(value = "id", required = false) int id, Model model) {

		libraryDto = libraryService.viewLibrary(id);
		model.addAttribute("boardView", libraryDto);
		return "edit";
	}

	@GetMapping("/write")
	public String write(Model model) {
		return "write";
	}

	@GetMapping("/view")
	public String view(@RequestParam(value = "id", required = false) int id, Model model) {
		libraryDto = libraryService.viewLibrary(id);
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
