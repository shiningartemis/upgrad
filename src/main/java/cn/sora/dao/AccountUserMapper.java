package cn.sora.dao;

import cn.sora.entity.AccountUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface AccountUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccountUser record);

    int insertSelective(AccountUser record);

    AccountUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountUser record);

    int updateByPrimaryKey(AccountUser record);

    //用账号查询用户
    AccountUser selectByAccountName(String accountName);

    //查询所有
    List<AccountUser> selectAll();
}
