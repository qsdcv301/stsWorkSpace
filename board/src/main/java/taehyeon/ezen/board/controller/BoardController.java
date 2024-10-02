package taehyeon.ezen.board.controller;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import taehyeon.ezen.board.dto.BoardDto;
import taehyeon.ezen.board.service.BoardService;
import taehyeon.ezen.board.util.Paging;

@Controller
public class BoardController {

	@Autowired
	private BoardService BoardService;

	BoardDto BoardDto;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@RequestParam(value = "id", required = false) Integer id,
					   @RequestParam(value = "pg", required = false, defaultValue = "1") int currentPage,
					   @RequestParam(value = "searchKey", required = false, defaultValue = "title") String searchKey,
					   @RequestParam(value = "searchVal", required = false) String searchVal, Model model) {
		int recordsPerPage = 10;
		int pagesPerGroup = 10;
		int totalRecords;
		List<BoardDto> BoardDtoList;

		if (searchKey != null && searchVal != null && !searchVal.isEmpty()) {
			totalRecords = BoardService.getSearchBoardCount(searchKey, searchVal);
			BoardDtoList = BoardService.listSearchBoard(searchKey, searchVal, (currentPage - 1) * recordsPerPage,
					recordsPerPage);
		} else {
			totalRecords = BoardService.getTotalBoardCount();
			BoardDtoList = BoardService.listBoard((currentPage - 1) * recordsPerPage, recordsPerPage);
		}

		Paging paging = new Paging(totalRecords, recordsPerPage, currentPage, pagesPerGroup);

		model.addAttribute("paging", paging);
		model.addAttribute("Board", BoardDtoList);
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

		BoardDto = BoardService.viewBoard(id);
		model.addAttribute("boardView", BoardDto);
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
		BoardDto = BoardService.viewBoard(id);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("boardView", BoardDto);
		return "view";
	}

	@PostMapping("/write")
	public String postWrite(BoardDto BoardDto){
		BoardService.insertBoard(BoardDto);
		return "redirect:/";
	}

	@PostMapping("/edit")
	public String postEdit(BoardDto BoardDto){
		BoardService.updateBoard(BoardDto);
	return "redirect:/";
	}

	@GetMapping("/del")
	public String Del(@RequestParam("id") int id){
		BoardService.deleteBoard(id);
		return "redirect:/";
	}
}
