package cn.sora.dao;

import cn.sora.entity.AccountRole;

public interface AccountRoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(AccountRole record);

    int insertSelective(AccountRole record);

    AccountRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(AccountRole record);

    int updateByPrimaryKey(AccountRole record);
}