package cn.sora.service;


import cn.sora.entity.AccountUser;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface AccountUserService {

    /**
     * 通过用户ID查询用户
     *
     * @param id 用户ID
     * @return 用户对象信息
     */
    public AccountUser selectByPrimaryKey(Integer id);

    /**
     * 通过用户账号查询用户
     *
     * @param accountName 用户账号
     * @return 用户对象信息
     */
    public AccountUser selectByAccountName(String accountName);

    public List<AccountUser> selectAll();
}
