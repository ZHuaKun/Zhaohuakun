package edu.soft.interceptor;

import edu.soft.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor {
    /**
     * 相当于aop的前置增强方法
     * @param request
     * @param response
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //从session获取user对象
        Object user = request.getSession().getAttribute("user");
        if (user != null && user instanceof User) {
            System.out.println("通过拦截器");
            return true;//返回true，通过拦截器
        }
            //跳转到登陆页面
        System.out.println("被拦截");
//        request.getRequestDispatcher("hello.do").forward(request,response);
        System.out.println("因未登录，被拦截");

        response.sendRedirect(request.getContextPath()+"/user/index.do");//重定向到首页
        return false;
    }

    /**
     * 相当于aop的后置增强方法
     * @param request
     * @param response
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("UserInterceptor.postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        System.out.println("UserInterceptor.afterCompletion");
    }
}
