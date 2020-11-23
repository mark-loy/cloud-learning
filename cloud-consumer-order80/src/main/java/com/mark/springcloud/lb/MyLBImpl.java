package com.mark.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/11/23 14:19
 */
@Component
public class MyLBImpl implements MyLB{

    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    private Integer getNext() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current == Integer.MAX_VALUE ? 0 : current + 1;
        }while (this.atomicInteger.compareAndSet(current, next));

        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> instanceList) {
        int index = getNext() % instanceList.size();
        return instanceList.get(index);
    }
}
