package cn.sora.controller;

import cn.sora.dao.TableDao;
import cn.sora.entity.AccountUser;
import cn.sora.service.AccountUserService;
import cn.sora.service.impl.AccountUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
    @RequestMapping("/list")
    public List<AccountUser> list(){
        List<AccountUser> result = accountUserService.selectAll();
        return result;
    }
}
