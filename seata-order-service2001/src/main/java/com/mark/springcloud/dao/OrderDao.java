package com.mark.springcloud.dao;

import com.mark.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/12/12 12:34
 */
@Mapper
@Repository
public interface OrderDao {

    int create(Order order);

    int update(@Param("userId") Long id, @Param("status") Integer status);
}
