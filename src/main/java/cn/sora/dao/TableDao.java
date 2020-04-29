package cn.sora.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface TableDao {
    @Select("select * from account_user")
    List<Map<String,Object>> listTable();
}
