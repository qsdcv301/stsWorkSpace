package taehyeon.com.kdtweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import taehyeon.com.kdtweb.service.BoardService;
import taehyeon.com.kdtweb.model.BoardDto;
import taehyeon.com.kdtweb.util.Paging;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
@RequestMapping("/bbs")
public class BoardController {

	@Autowired
	private BoardService boardService;

	BoardDto boardView;

	@GetMapping
	public String bbs(@RequestParam(value = "mode", required = false, defaultValue = "list") String mode,
			@RequestParam(value = "num", required = false) Long num,
			@RequestParam(value = "pg", required = false, defaultValue = "1") int currentPage,
			@RequestParam(value = "searchKey", required = false, defaultValue = "title") String searchKey,
			@RequestParam(value = "searchVal", required = false) String searchVal, Model model) {

		model.addAttribute("mode", mode);

		switch (mode) {
		case "write":
			return "bbs/write";
		case "edit":
			boardView = boardService.viewBoard(num);
			model.addAttribute("boardView", boardView);
			return "bbs/edit";
		case "view":
			boardView = boardService.viewBoard(num);
			boardService.updateCount(num); // 조회수 업데이트

			model.addAttribute("currentPage", currentPage);
			model.addAttribute("boardView", boardView);
			return "bbs/view";
		default:
			int recordsPerPage = 10;
			int pagesPerGroup = 10;
			int totalRecords;
			List<BoardDto> boardList;

			if (searchKey != null && searchVal != null && !searchVal.isEmpty()) {
				totalRecords = boardService.getSearchBoardCount(searchKey, searchVal);
				boardList = boardService.listSearchBoard(searchKey, searchVal, (currentPage - 1) * recordsPerPage,
						recordsPerPage);
			} else {
				totalRecords = boardService.getTotalBoardCount();
				boardList = boardService.listBoard((currentPage - 1) * recordsPerPage, recordsPerPage);
			}

			Paging paging = new Paging(totalRecords, recordsPerPage, currentPage, pagesPerGroup);

			model.addAttribute("paging", paging);
			model.addAttribute("boardList", boardList);
			model.addAttribute("encodeSearchKey", URLEncoder.encode(searchKey, StandardCharsets.UTF_8));
			model.addAttribute("encodeSearchVal",
					URLEncoder.encode(searchVal != null ? searchVal : "", StandardCharsets.UTF_8));
		}

		return "bbs/list";
	}

	@GetMapping("/del")
	public String deleteMember(@RequestParam("num") int num) {
		boardService.deleteBoard(num);
		return "redirect:/bbs?mode=list";
	}

	@PostMapping("/edit")
	public String editPost(BoardDto dto) {
		boardService.updateBoard(dto);
		return "redirect:/bbs?mode=list";
	}

	@PostMapping("/write")
	public String writePost(BoardDto dto) {
		boardService.insertBoard(dto);
		return "redirect:/bbs?mode=list";
	}

}
