package taehyeon.com.kdtweb;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import taehyeon.com.kdtweb.model.BoardDto;
import taehyeon.com.kdtweb.model.UserDto;
import taehyeon.com.kdtweb.service.BoardService;
import taehyeon.com.kdtweb.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		List<BoardDto> bbsList = boardService.listBoard(0, 8);
		model.addAttribute("bbsList", bbsList);
		return "home";
	}

	@GetMapping("/findidpass")
	public String findidpassPage(HttpServletRequest request, Model model) {
		return "findidpass";
	}

	@GetMapping("/register")
	public String registerPage(HttpServletRequest request, Model model) {
		return "register";
	}

	@PostMapping("/login")
	public String loginOk(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("userid") String userid, @RequestParam("userpass") String userpass,
			@RequestParam(value = "rid", required = false) String rid, HttpSession session, Model model) {
		// Admin login
		if ("admin".equals(userid)) {
			if ("admin".equals(userpass)) {
				session.setAttribute("userid", "admin");
				if ("ok".equals(rid)) {
					session = request.getSession();
					Cookie userCookie = new Cookie("userid", userid);
					userCookie.setMaxAge(60 * 60 * 24 * 1);
					response.addCookie(userCookie);
				}
				return "redirect:/";
			} else {
				model.addAttribute("error", "아이디 또는 비밀번호가 틀렸습니다.");
				return "redirect:/";
			}
		} else {
			if (userService.getByUserId(model, userid) != null) {
				session.setAttribute("userid", userid);
				if ("ok".equals(rid)) {
					session = request.getSession();
					Cookie userCookie = new Cookie("userid", userid);
					userCookie.setMaxAge(60 * 60 * 24 * 1);
					response.addCookie(userCookie);
				}
				return "redirect:/"; // 로그인 성공 시 홈으로 리다이렉트
			} else {
				model.addAttribute("error", "아이디 또는 비밀번호가 틀렸습니다.");
				return "redirect:/"; // 에러 메시지와 함께 다시 로그인 페이지로 리턴
			}
		}
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request, Model model, HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/memlist")
	public String memlistPage(HttpServletRequest request, Model model) {
		return "memlist";
	}

	@GetMapping("/editmem")
	public String editMem(HttpServletRequest request, HttpSession session, Model model) {
		String userid = (String) session.getAttribute("userid");
		UserDto user = userService.getByUserId(model, userid);
		model.addAttribute("user", user);
		String emailid = "";
		String emailDomain = "";
		String tel1 = "";
		String tel2 = "";
		String tel3 = "";

		String useremail = user.getUseremail();
		String usertel = user.getUsertel();

		if (useremail != null) {
			String[] email = useremail.split("@");
			emailid = email.length > 0 ? email[0] : "";
			emailDomain = email.length > 1 ? email[1] : "";
		}

		if (usertel != null) {
			String[] tel = usertel.split("-");
			tel1 = tel.length > 0 ? tel[0] : "";
			tel2 = tel.length > 1 ? tel[1] : "";
			tel3 = tel.length > 2 ? tel[2] : "";
		}
		model.addAttribute("user", user);
		model.addAttribute("emailid", emailid);
		model.addAttribute("emailDomain", emailDomain);
		model.addAttribute("tel1", tel1);
		model.addAttribute("tel2", tel2);
		model.addAttribute("tel3", tel3);
		return "editmem";
	}

	@PostMapping("/editok")
	public String editOk(UserDto dto, HttpSession session, Model model) {
		userService.updateUser(dto);
		return "redirect:/";
	}

}
