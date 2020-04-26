package cn.sora.dao;

import cn.sora.entity.UpgradeArea;

public interface UpgradeAreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UpgradeArea record);

    int insertSelective(UpgradeArea record);

    UpgradeArea selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UpgradeArea record);

    int updateByPrimaryKey(UpgradeArea record);
}