package org.example.orderservice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.orderservice.pojo.Order;
import org.springframework.stereotype.Component;

@Mapper
public interface OrderMapper {
    @Select( "select * from tb_orderinfo where id = #{id};" )
    Order findById(@Param( "id" ) Integer id);
}
