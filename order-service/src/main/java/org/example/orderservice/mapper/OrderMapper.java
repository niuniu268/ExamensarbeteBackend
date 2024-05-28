package org.example.orderservice.mapper;

import org.apache.ibatis.annotations.*;
import org.example.orderservice.pojo.Order;
import org.springframework.stereotype.Component;

@Mapper
public interface OrderMapper {

    @Select( "select * from tb_orderinfo where id = #{id};" )
    Order findById(@Param( "id" ) Integer id);

    @Insert("INSERT INTO tb_orderinfo (userid, hotelid, totalprice, days) VALUES (#{userid}, #{hotelid}, #{totalprice}, #{days})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(@Param("userid") Integer userid, @Param("hotelid") String hotelid, @Param("totalprice") String totalprice, @Param("days") String days);

    @Update("UPDATE tb_orderinfo SET userid = #{userid}, hotelid = #{hotelid}, totalprice = #{totalprice}, days = #{days} WHERE id = #{id}")
    void update(@Param("id") Integer id, @Param("userid") Integer userid, @Param("hotelid") String hotelid, @Param("totalprice") String totalprice, @Param("days") String days);

    @Delete("DELETE FROM tb_orderinfo WHERE id = #{id}")
    void delete(@Param("id") Integer id);

}
