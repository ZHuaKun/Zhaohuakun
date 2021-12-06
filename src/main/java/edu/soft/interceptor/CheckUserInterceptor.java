package edu.soft.interceptor;

import edu.soft.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckUserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //获取session对象
        HttpSession session = request.getSession();
        //判定session中有无user对象
        Object obj = session.getAttribute("user");
        if((obj == null) &&(obj instanceof User)){//obj是否是User的实例
            System.out.println("abc");
            return true;//拦截器放行

        }
        System.out.println("因未登录而被拦截");
        response.sendRedirect("/index.jsp");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
