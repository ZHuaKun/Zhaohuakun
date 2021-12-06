package edu.soft.controller;

import edu.soft.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "param1")
public class MyController {
    @RequestMapping("testMaV")
    public ModelAndView testMaV(){
        User user = new User();
        user.setUsername("peter");//User对象创建实例
        ModelAndView MaV = new ModelAndView();//ModelAndView对象创建实例
        System.out.println("MyController.testMaV");
        MaV.addObject("user",user);//向默认作用域request中添加User对象实例
        MaV.setViewName("hello");//相当于跳转的url(前缀+hello+后缀)
        return MaV;
    }

    @RequestMapping("testForward")//测试转发跳转
    public String testForward(){
        System.out.println("MyController.testForward");
       // return "hello";//转发到WEB-INF/pages/下的hello.jsp
        return "forward:/reg.jsp";//转发到webapp下的reg.jsp
    }
    @RequestMapping("testRedirect")//测试重定向跳转
    public String testRedirect(){
        System.out.println("MyController.testRedirect");
        // return "redirect:/WEB-INF/pages/hello.jsp";//重定向失败，因不能从client直接访问service端的WEB-INF目录中资源
        return "redirect:/reg.jsp";//重定向到webapp下的reg.jsp
    }

    @RequestMapping(value = "/hello.do",method = {RequestMethod.GET})
    public String hello(HttpServletRequest request){
    //接受处理，调用业务，跳转页面
        //接收数据
        String name = request.getParameter("name");//通过参数名(url),获取参数值
        System.out.println("name="+name);//通过参数名(url),获取参数值
        System.out.println("------hello()------");
        return "hello";
        //拼接URL：前缀+hello+后缀
    }

    @RequestMapping(value = "/param1",method = {RequestMethod.GET,RequestMethod.POST})
    public String param1(HttpServletRequest request){
        System.out.println("------param1()------");
        //接受处理，调用业务，跳转页面
        //接收数据
        String username = request.getParameter("username");//通过参数名(url),获取参数值
        String age = request.getParameter("age");//通过参数名(url),获取参数值
        System.out.println("username="+username+"age="+age);
        request.setAttribute("username",username);
        request.setAttribute("age",age);
        return "hello";//默认用重定向方式跳转
        //拼接URL：前缀+hello+后缀
    }


    @RequestMapping(value = "/param2.do")
    public String param2(HttpServletRequest request){//这个方法对应的url路径:http://localhost/[项目名]/param2.do方法
        System.out.println("------param2()------");
        //接受处理，调用业务，跳转页面
        //接收数据
        String username = request.getParameter("username");//通过参数名(url),获取参数值
        String age = request.getParameter("age");//通过参数名(url),获取参数值
        System.out.println("username="+username+"age="+age);
        request.setAttribute("username",username);
        request.setAttribute("age",age);
        //return "forward:hello";//默认转发方式跳转(url不变)
        return "redirect:hello";//默认用重定向方式跳转(url变化)
        //拼接URL：前缀+hello+后缀
    }


    @RequestMapping(value = "/param3.do")
    public String param3(HttpServletRequest request,HttpSession session){//这个方法对应的url路径:http://localhost/[项目名]/param3.do方法
        System.out.println("------param3()------");
        //接受处理，调用业务，跳转页面
        //接收数据
        String username = request.getParameter("username");//通过参数名(url),获取参数值
        String age = request.getParameter("age");//通过参数名(url),获取参数值
        System.out.println("username="+username+"age="+age);
        session.setAttribute("username",username);//将数据放入session
        session.setAttribute("age",age);//将数据放入session
        //return "forward:hello";//默认转发方式跳转(url不变)
        return "redirect:hello";//默认用重定向方式跳转(url变化)
        //拼接URL：前缀+hello+后缀
    }

    @RequestMapping(value = "/param4.do")
    public String param4(String username ,int age){//这个方法对应的url路径:http://localhost/[项目名]/param4.do方法
        System.out.println("------param4()------");
        //接受处理，调用业务，跳转页面
        //接收数据
       /* String username = request.getParameter("username");//通过参数名(url),获取参数值
        String age = request.getParameter("age");//通过参数名(url),获取参数值
        System.out.println("username="+username+"age="+age);
        session.setAttribute("username",username);//将数据放入session
        session.setAttribute("age",age);//将数据放入session
        //return "forward:hello";//默认转发方式跳转(url不变)*/
        System.out.println("username="+username+"age="+age);
        return "hello";//同等与return "forward:hello";
        //拼接URL：前缀+hello+后缀
    }

    @RequestMapping(value = "/param5.do")
    public String param5(@RequestParam(value = "username",required = false) String u ,@RequestParam(value = "age",required = true ,defaultValue = "20") int a){//数据绑定
        System.out.println("------param5()------");
        System.out.println("username="+u+"age="+a);
        return "hello";//同等与return "forward:hello";
        //拼接URL：前缀+hello+后缀
    }
    @RequestMapping(value = "/param6.do")
    public String param6(HttpServletRequest request){//数据绑定
        System.out.println("------param6()------");
        System.out.println("username="+request.getParameter("username")+",age="+request.getParameter("age"));
        return "hello";//同等与return "forward:hello";
        //拼接URL：前缀+hello+后缀
    }

    @RequestMapping(value = "/test1")
    public String test1(){
        System.out.println("------test1()------");
        return "forward:/param2/test3";//跳转到控制器test2().do
    }
    @RequestMapping(value = "/test2")
    public String test2(){
        System.out.println("------test2()------");
        return "hello";//跳转到控制器test2().do
    }
}
