package cn.sora.controller;


import cn.sora.entity.AccountUser;
import cn.sora.service.impl.AccountUserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private AccountUserServiceImpl accountUserService;

    // 测试方法
    @RequestMapping("/test1")
    @ResponseBody
    public String sayHello(){
        System.out.println("test1.sayHello");
        return "hello springboot";
    }
    //测试方法2
    @RequestMapping("/test2")
    public String sayHi(Model model){
        //把数据存入model
        model.addAttribute("name","saber");
        //返回hi.html
        return "/test/hi";
    }

    //测试方法4
    @RequestMapping("/test4")
    public String test4(){
        //返回hi.html
        return "/home/index";
    }
    @RequestMapping("/userView")
    //thymeleaf需要返回json格式才能解析？
    @ResponseBody
    public String userView(String accountName){
        System.out.println("进来请求了");
        System.out.println(accountName);
        AccountUser accountUser = accountUserService.selectByAccountName(accountName);
        String user_name = accountUser.getUserName();
        int user_id = accountUser.getId();
        String pwd = accountUser.getUserPwd();
        System.out.println(user_name);
        System.out.println(user_id);
        System.out.println(pwd);
        return user_id+"号用户名字："+user_name;
    }
//    public String userView(Integer id){
//        System.out.println("进来请求了");
//        System.out.println(id);
//        AccountUser accountUser = accountUserService.selectByPrimaryKey(id);
//        String user_name = accountUser.getUserName();
//        int user_id = accountUser.getId();
//        String pwd = accountUser.getUserPwd();
//        System.out.println(user_name);
//        System.out.println(user_id);
//        System.out.println(pwd);
//        return user_id+"号用户名字："+user_name;
//    }

}
