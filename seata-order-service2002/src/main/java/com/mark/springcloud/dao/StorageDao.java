package com.mark.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/12/12 15:22
 */
@Mapper
public interface StorageDao {

    void decr(@Param("productId") Long productId, @Param("count") Integer count);

}
