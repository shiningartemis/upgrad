package cn.sora.service.impl;

import cn.sora.dao.AccountUserMapper;
import cn.sora.entity.AccountUser;
import cn.sora.service.AccountUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import cn.sora.entity.SysUser;
//import cn.sora.mapper.SysUserMapper;
//import cn.sora.service.SysUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

@Service(value = "accountUserService")
public class AccountUserServiceImpl implements AccountUserService {

    @Autowired
    private AccountUserMapper accountUserMapper;

    //测试方法，用主键-id查询
    @Override
    public AccountUser selectByPrimaryKey(Integer id) {
        return accountUserMapper.selectByPrimaryKey(id);
    }

}
