package com.mark.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/11/23 14:17
 */
public interface MyLB {

    ServiceInstance instance(List<ServiceInstance> instanceList);

}
