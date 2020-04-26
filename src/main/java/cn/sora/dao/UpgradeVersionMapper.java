package cn.sora.dao;

import cn.sora.entity.UpgradeVersion;

public interface UpgradeVersionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UpgradeVersion record);

    int insertSelective(UpgradeVersion record);

    UpgradeVersion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UpgradeVersion record);

    int updateByPrimaryKey(UpgradeVersion record);
}