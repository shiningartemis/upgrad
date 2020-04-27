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
public class LoginController {

    //测试方法
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    // 跳转：登录页
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/linkStart/login";
    }
    // 跳转：无权限提示
    @RequestMapping("/noAuth")
    public String noAuth(){
        return "/linkStart/noAuth";
    }

    /**
     * 登录逻辑处理
     */
    @RequestMapping("/login")                                                //大问题
    public String login(String username,String password,Model model){       //Model model 参数不光是传进，没有的也可保留，传出？
        /**
         * 使用Shiro编写认证操作
         */
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //3.执行登录方法
        try {
            //这个subject调用login方法>>会到UserRealm-执行认证逻辑 中，传参(token)被arg0接收
            subject.login(token);

            //登录成功
            //跳转到index.html   redirect：重定向
            return "redirect:/index";
        } catch (UnknownAccountException e) {
            //e.printStackTrace();
            //登录失败:用户名不存在
            model.addAttribute("msg", "用户名不存在");
            return "linkStart/login";
        }catch (IncorrectCredentialsException e) {
            //e.printStackTrace();
            //登录失败:密码错误
            model.addAttribute("msg", "密码错误");
            return "linkStart/login";
        }catch (Exception e){
            model.addAttribute("msg", "密码或账号有误");
            return "linkStart/login";
        }
    }

}
