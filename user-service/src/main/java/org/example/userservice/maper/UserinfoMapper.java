package org.example.userservice.maper;

import org.apache.ibatis.annotations.*;
import org.example.userservice.pojo.UserInfo;
@Mapper
public interface UserinfoMapper {

    @Select("select * from tb_userinfo where username = #{username};")
    UserInfo findByUsername (@Param("username") String username);

    @Select( "select * from tb_userinfo where id = #{id};" )
    UserInfo findById(@Param( "id" ) Integer id);

    @Update("UPDATE tb_userinfo SET password = #{password} WHERE username = #{username}")
    void update(@Param("username") String username, @Param("password") String password);

    @Insert("INSERT INTO tb_userinfo (username, password, enable) VALUES (#{username}, #{password}, #{enable})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(UserInfo userInfo);

    @Delete("DELETE FROM tb_userinfo WHERE username = #{username}")
    void delete(String username);
}
