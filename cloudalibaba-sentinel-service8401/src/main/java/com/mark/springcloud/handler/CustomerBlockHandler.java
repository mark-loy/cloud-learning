package com.mark.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mark.springcloud.entity.CommonResult;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/12/8 15:22
 */
public class CustomerBlockHandler {

    /**
     * 外部类的兜底方法，必须为public static的
     * @param exception
     * @return
     */
    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(400, exception.getMessage() + " 失败 /(ㄒoㄒ)/~~", null);
    }

}
