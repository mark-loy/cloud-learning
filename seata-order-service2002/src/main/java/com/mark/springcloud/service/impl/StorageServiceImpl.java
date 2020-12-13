package com.mark.springcloud.service.impl;

import com.mark.springcloud.dao.StorageDao;
import com.mark.springcloud.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/12/12 16:06
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public int decr(Long productId, Integer count) {

        storageDao.decr(productId, count);

        return 0;
    }
}
