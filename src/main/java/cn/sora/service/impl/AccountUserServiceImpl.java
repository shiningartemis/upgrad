package cn.sora.service.impl;

import cn.sora.dao.AccountUserMapper;
import cn.sora.entity.AccountUser;
import cn.sora.service.AccountUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service(value = "accountUserService")
public class AccountUserServiceImpl implements AccountUserService {

    @Autowired
    private AccountUserMapper accountUserMapper;

    //测试方法，用主键-id查询
    @Override
    public AccountUser selectByPrimaryKey(Integer id) {
        return accountUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public AccountUser selectByAccountName(String accountName) {
        return accountUserMapper.selectByAccountName(accountName);
    }

    @Override
    public List<AccountUser> selectAll() {
        List<AccountUser> list = accountUserMapper.selectAll();
        return list;
    }

    @Override
    public List<AccountUser> selectAllLike(String accountName) {
        List<AccountUser> list = accountUserMapper.selectAllLike(accountName);
        return list;
    }

    @Override
    public List<AccountUser> selectSomeLike(Map map) {
        List<AccountUser> list = accountUserMapper.selectSomeLike(map);
        return list;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return accountUserMapper.deleteByPrimaryKey(id);
    }

//    @Override
//    public List<AccountUser> selectAllLike(String accountName) {
//        List<AccountUser> list = accountUserMapper.selectAllLike();
//        return list;
//    }


}
