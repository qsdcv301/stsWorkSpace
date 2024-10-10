package net.taehyeon.community.controller;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import net.taehyeon.community.dao.MemberDao;
import net.taehyeon.community.mapper.MemberMapper;
import net.taehyeon.community.model.CustomUserDetails;
import net.taehyeon.community.model.Member;
import net.taehyeon.community.model.MemberRole;
import net.taehyeon.community.service.ClientIpAddress;
import net.taehyeon.community.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private MemberMapper memberMapper;
	
    @Autowired
    private ClientIpAddress clientIpAddress;

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @ModelAttribute
    public void addCommonAttributes(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Member member = null;

        if (auth != null && auth.isAuthenticated() && auth.getPrincipal() instanceof CustomUserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            String userid = userDetails.getUsername();

            member = memberMapper.getMemberUserId(userid);
        }

        model.addAttribute("member", member);
    }
    
    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String registerForm(@RequestParam("userid") String userid, @RequestParam("userpass") String noopUserpass,
                               @RequestParam("username") String username, @RequestParam("useremail") String useremail,
                               @RequestParam("usertel") String usertel, @RequestParam(value = "zipcode", required = false) Integer zipcode,
                               @RequestParam("address") String address, @RequestParam("detail_address") String detail_address,
                               @RequestParam("extra_address") String extra_address, @RequestParam("role") String role,
                               @RequestParam("userprofile") String userprofile,
                               @RequestParam(value = "userimg", required = false) MultipartFile userimg, HttpServletRequest request,
                               Model model) {

        Member member = new Member();
        MemberRole memberRole = new MemberRole();

        clientIpAddress.setClientIpAddress(request);
        //비밀번호 암호화
        String userpass = bCryptPasswordEncoder.encode(noopUserpass);
        String userip = clientIpAddress.getClientIpAddress();
        member.setUserid(userid);
        member.setUserpass(userpass);
        member.setUsername(username);
        member.setUseremail(useremail);
        member.setUsertel(usertel);
        member.setZipcode(zipcode);
        member.setAddress(address);
        member.setDetail_address(detail_address);
        member.setExtra_address(extra_address);
        member.setUserprofile(userprofile);
        member.setUserip(userip);

        if (userimg != null && !userimg.isEmpty()) {
            try {
                fileUploadService.setAbsolutePath("members");
                String[] exts = {"jpg", "gif", "png"};
                fileUploadService.setAllowedExt(exts);
                long maxsize = 1 * 1024 * 1024;
                fileUploadService.setMaxSize(maxsize);
                String[] filesname = fileUploadService.uploadFile(userimg);
                member.setOruserimg(filesname[0]);
                member.setUserimg(filesname[1]);
            } catch (Exception e) {
                model.addAttribute("error", e.getMessage());
                return "home";
            }
        }

        memberDao.insertMem(member);

        //primary key auto increment 값 얻기
        int membersid = member.getId();
        memberRole.setId(membersid);
        memberRole.setUserRole(role);
        memberDao.insertMemRole(memberRole);

        model.addAttribute("nimg", member.getUserimg());
        AbandonedConnectionCleanupThread.checkedShutdown();
        return "home";
    }

    @GetMapping("/login")
    public String LoginForm(@RequestParam(value = "error", required = false) String error, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "아이디 또는 비밀번호가 틀렸습니다.");
        }
        return "login";
    }

    @GetMapping("/member")
    public String memberIndex(Model model) {
        return "member.index";
    }

    @GetMapping("/admin")
    public String adminIndex(Model model) {
        return "admin.index";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Home(Locale locale, Model model) {
        model.addAttribute("error","");
        return "home";
    }
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        model.addAttribute("error","");
        return "home";
    }
}
