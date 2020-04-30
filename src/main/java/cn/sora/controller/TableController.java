package cn.sora.controller;

import cn.sora.dao.TableDao;
import cn.sora.entity.AccountUser;
import cn.sora.service.AccountUserService;
import cn.sora.service.impl.AccountUserServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TableController {
    @Resource
    TableDao tableDao;

    @Autowired
    private AccountUserServiceImpl accountUserService;

    //test
    @RequestMapping("/list1")
    public List<Map<String, Object>> list1() {
        List<Map<String, Object>> result = tableDao.listTable();
        return  result;
        //JsonAlias result = new JsonAlias();
       // result.setPage(tableDao.listTable());
        //return result;
    }
    //test
    @RequestMapping("/list2")
    public List<AccountUser> list(@RequestParam(value = "page",defaultValue="1") int pageNum, @RequestParam(value = "limit",defaultValue="5") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<AccountUser> result = accountUserService.selectAll();
        PageInfo<AccountUser> bean = new PageInfo<AccountUser>(result);
        Long tot = bean.getTotal();
        //model.addAttribute("msg",tot);
        return result;
    }
}
