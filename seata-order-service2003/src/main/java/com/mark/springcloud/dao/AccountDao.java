package com.mark.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/12/12 16:21
 */
@Mapper
public interface AccountDao {

    void decr(@Param("userId") Long userId, @Param("money")BigDecimal money);

}
