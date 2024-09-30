package net.taehyeon.community.controller;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import net.taehyeon.community.dao.MemberDao;
import net.taehyeon.community.model.Member;
import net.taehyeon.community.service.ClientIpAddress;
import net.taehyeon.community.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    private ClientIpAddress clientIpAddress;

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private FileUploadService fileUploadService;

    @GetMapping("/register")
    public String register(Model model) {
        return "member.register";
    }

    @PostMapping("/register")
    public String registerForm(@RequestParam("userid") String userid, @RequestParam("userpass") String noopUserpass, @RequestParam("username") String username, @RequestParam("useremail") String useremail, @RequestParam("usertel") String usertel, @RequestParam(value = "zipcode", required = false) Integer zipcode, @RequestParam("address") String address, @RequestParam("detail_address") String detail_address, @RequestParam("extra_address") String extra_address, @RequestParam("userprofile") String userprofile, @RequestParam(value = "userimg", required = false) MultipartFile userimg, HttpServletRequest request, Model model) {

        Member member = new Member();
        clientIpAddress.setClientIpAddress(request);
        String userip = clientIpAddress.getClientIpAddress();
        member.setUserid(userid);
        member.setUserpass(noopUserpass);
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
                long maxsize = 1 * 1024 * 1024; // 1메가
                fileUploadService.setMaxSize(maxsize);
                String[] filesname = fileUploadService.uploadFile(userimg);
                member.setOruserimg(filesname[0]);
                member.setUserimg(filesname[1]);
            } catch (Exception e) {
                model.addAttribute("error", e.getMessage());
                return "member.index";
            }
        }

        memberDao.insertMem(member);
        model.addAttribute("nimg",member.getUserimg());
        AbandonedConnectionCleanupThread.checkedShutdown();
        return "member.index";
    }

    @GetMapping("/member")
    public String memberIndex(Model model) {
        return "member.index";
    }

    @GetMapping("/admin")
    public String adminIndex(Model model) {
        return "admin.index";
    }
}
