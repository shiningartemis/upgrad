package cn.sora.dao;

import cn.sora.entity.UpgradeService;

public interface UpgradeServiceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UpgradeService record);

    int insertSelective(UpgradeService record);

    UpgradeService selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UpgradeService record);

    int updateByPrimaryKey(UpgradeService record);
}