package com.hust18.hrm.dao;

import com.hust18.hrm.dao.provider.DeptDynaSqlProvider;
import com.hust18.hrm.domain.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

import static com.hust18.hrm.util.common.HrmConstants.DEPTTABLE;

public interface DeptDao {
    //动态查询
    @SelectProvider(type = DeptDynaSqlProvider.class,method="selectWhitParams")
    List<Dept> selectByPage(Map<String,Object> params);
    @SelectProvider(type = DeptDynaSqlProvider.class,method = "count")
    Integer count(Map<String,Object> params);
    @Select("select * from "+DEPTTABLE+"")
    List<Dept> selectAllDept();
    @Select("select * from" +DEPTTABLE+" where ID = #{id}")
    Dept selectById(int id);
    //根据id删除部门
    @Delete("delete from "+DEPTTABLE+" where id = #{id}")
    void deleteById(Integer id);
    //动态插入部门
   @SelectProvider(type = DeptDynaSqlProvider.class,method ="insertDept" )
    void save(Dept dept);
   @SelectProvider(type = DeptDynaSqlProvider.class,method = "updateDept")
    void update(Dept dept);



}