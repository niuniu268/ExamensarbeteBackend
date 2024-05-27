package org.example.userservice.maper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.userservice.pojo.UserInfo;
@Mapper
public interface UserinfoMapper {

    @Select("select * from tb_userinfo where username = #{username};")
    UserInfo findByUsername (@Param("username") String username);

    @Select( "select * from tb_userinfo where id = #{id};" )
    UserInfo findById(@Param( "id" ) Integer id);
}
