package cn.sora.controller;

import cn.sora.entity.AccountUser;
import cn.sora.service.AccountUserService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AccountController {
    @Autowired
    AccountUserService accountUserService;

    @RequestMapping("/userList")
    @ResponseBody
    public String getList(@RequestParam(value = "page",defaultValue="1") int pageNum, @RequestParam(value = "limit",defaultValue="5") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AccountUser> userList = accountUserService.selectAll();
        PageInfo<AccountUser> bean = new PageInfo<AccountUser>(userList);
        //获取总数
        long totalCount = bean.getTotal();
        //坑2：获取分页相关内容，用分页插件的方法就是了，不要用乱七八糟的
        //int totalCount  = userList.size();

        JSONObject obj = new JSONObject();
        //前台通过key值获得对应的value值
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count", totalCount );
        obj.put("data", userList);
        return obj.toJSONString();
    }
//    坑1：历史返回版本--返回的参数不符合标准
//    public List<AccountUser> list(@RequestParam(value = "page",defaultValue="1") int pageNum, @RequestParam(value = "limit",defaultValue="5") int pageSize){
//        PageHelper.startPage(pageNum,pageSize);
//        List<AccountUser> result = accountUserService.selectAll();
//        PageInfo<AccountUser> bean = new PageInfo<AccountUser>(result);
//        Long tot = bean.getTotal();
//        //model.addAttribute("msg",tot);
//        return result;
//    }
}
