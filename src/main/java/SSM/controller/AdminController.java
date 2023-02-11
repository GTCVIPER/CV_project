package SSM.controller;

import SSM.pojo.Admin;
import SSM.service.*;
import SSM.utils.JwtUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Resource
    private AdminService adminService;

    @Resource
    private StudentService studentService;

    @Resource
    private ApplicationFilesService applicationFilesService;

    @Resource
    private PioneerService pioneerService;

    @RequestMapping("/login")
    public String login(HttpServletResponse response, String userId, String passwd, HttpServletRequest request) {


//        System.out.println(userId + "-->" + passwd);
        if (userId != null && passwd != null) {

            final Admin admin = adminService.loginAdmin(userId, passwd);

            if (admin != null) {
                // 生成 token 校验
                String token = JwtUtils.sign(admin.getAdId(), admin.getAdPassword());

                if (token != null) {
                    System.out.println("token:-->" + token);
                    // token 放 cookie 里
                    final Cookie cookie = new Cookie("_COOKIE_NAME", token);
                    cookie.setMaxAge(3600); // 设置 token 有效时间
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }

                final HttpSession session = request.getSession();
                session.setAttribute("stus", studentService.findALLStudentsID());
                session.setAttribute("apps", applicationFilesService.findAllApplicationFilesID());
                session.setAttribute("pinos", pioneerService.findAllPioneerFilesID());

                return "home";
            }

        }
        return "index";
    }
}


