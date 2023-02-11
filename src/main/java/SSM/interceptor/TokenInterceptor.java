package SSM.interceptor;

import SSM.utils.JwtUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * SpringMVC 拦截器
 */
public class TokenInterceptor implements HandlerInterceptor {

    /*
    拦截器 针对访问控制器进行拦截
    作为权限判断
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("utf-8");
        final Cookie cookie = getCookieByName(request, "_COOKIE_NAME");

        // 如果已经登录，不拦截
        if (cookie != null) {

            // 验证token是否正确
            return JwtUtils.verify(cookie.getValue());
        } else {
            // 如果没有登陆，则重定向至登陆页面
            System.out.println("token 校验拦截");

            response.setStatus(401);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
//
            return false;
        }

    }


    /*
    根据 cookie名字获取 cookie
     */
    public static Cookie getCookieByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = readCookieMap(request);

        return cookieMap.getOrDefault(name, null);
    }


    /*
    将 cookie 封装到 map
     */
    private static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<>();
        final Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                c.setMaxAge(60 * 60);
                cookieMap.put(c.getName(), c);
            }
        }

        return cookieMap;
    }


//    /*
//    返回信息给客户端
//     */
//    private void responseMessage(HttpServletRequest request, HttpServletResponse response, PrintWriter out,ApiResponse)
}
