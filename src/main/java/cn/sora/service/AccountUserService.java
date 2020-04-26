package cn.sora.service;


import cn.sora.entity.AccountUser;

public interface AccountUserService {

    /**
     * 通过用户ID查询用户
     *
     * @param id 用户ID
     * @return 用户对象信息
     */
    public AccountUser selectByPrimaryKey(Integer id);
}
