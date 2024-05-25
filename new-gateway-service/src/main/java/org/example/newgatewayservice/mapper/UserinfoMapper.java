package org.example.newgatewayservice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import org.example.newgatewayservice.pojo.UserInfo;

@Mapper
public interface UserinfoMapper {

    @Select("select * from tb_userinfo where username = #{username};")
    UserInfo findByUsername (@Param("username") String username);
}
