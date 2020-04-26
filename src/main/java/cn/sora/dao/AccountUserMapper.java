package cn.sora.dao;

import cn.sora.entity.AccountUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccountUser record);

    int insertSelective(AccountUser record);

    AccountUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountUser record);

    int updateByPrimaryKey(AccountUser record);
}
