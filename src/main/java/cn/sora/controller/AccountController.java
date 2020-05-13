package cn.sora.controller;

import cn.sora.entity.AccountUser;
import cn.sora.service.AccountUserService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AccountController {
    @Autowired
    AccountUserService accountUserService;

    @RequestMapping("/userList")
    @ResponseBody
    public String getList(@RequestParam(value = "page",defaultValue="1") int pageNum, @RequestParam(value = "limit",defaultValue="5") int pageSize,AccountUser accountUser) {
        PageHelper.startPage(pageNum, pageSize);
        System.out.println(accountUser.getAccountName());

        try{
            if(accountUser.getAccountName() != null || accountUser.getRoleId() != null){
                String a = "";
                String b = "";
                a = accountUser.getAccountName();
                b = String.valueOf(accountUser.getRoleId());
                Map map =new HashMap();
                map.put("account_name",a);
                map.put("role_id",b);
                System.out.println("1-3:"+map);

                List<AccountUser> userLikeList = accountUserService.selectSomeLike(map);
                System.out.println("2:"+userLikeList);
                PageInfo<AccountUser> bean = new PageInfo<AccountUser>(userLikeList);
                //获取总数
                long totalCount = bean.getTotal();
                //坑2：获取分页相关内容，用分页插件的方法就是了，不要用乱七八糟的
                //int totalCount  = userList.size();

                JSONObject obj = new JSONObject();
                //前台通过key值获得对应的value值
                obj.put("code", 0);
                obj.put("msg", "");
                obj.put("count", totalCount );
                obj.put("data", userLikeList);
                System.out.println("3:"+obj.toJSONString());
                return obj.toJSONString();

            }
        }catch (Exception e){

        }

        List<AccountUser> userList = accountUserService.selectAll();
        System.out.println("外-2:"+userList);
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
        System.out.println("外-3:"+obj.toJSONString());
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

    @RequestMapping("/userLikeList")
    @ResponseBody
    public String getLikeList(@RequestParam(value = "page",defaultValue="1") int pageNum, @RequestParam(value = "limit",defaultValue="5") int pageSize,AccountUser accountUser) {
        PageHelper.startPage(pageNum, pageSize);
        if(accountUser.getAccountName() != null){
            AccountUser act = accountUserService.selectByAccountName(accountUser.getAccountName());
            JSONObject obj = new JSONObject();
            //前台通过key值获得对应的value值
            obj.put("code", 0);
            obj.put("msg", "");
            obj.put("count", 1 );
            obj.put("data", act);
            return obj.toJSONString();
        }
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

    //accountUserMapper.deleteByPrimaryKey(id);
    /**
     * 删除
     */
    @RequestMapping("deleteAccount")
    public @ResponseBody String informationDelete(AccountUser accountUser) throws UnsupportedEncodingException {
        Integer id = accountUser.getId();
        accountUserService.deleteByPrimaryKey(id);
        System.out.println(id);
        JSONObject json = new JSONObject();
        return json.toString();
    }

    @RequestMapping("addAccount")
    public String addAccount(AccountUser accountUser){
        return null;
    }
}
