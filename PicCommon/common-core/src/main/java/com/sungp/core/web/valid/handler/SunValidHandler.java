package com.sungp.core.web.valid.handler;

import com.sungp.core.web.valid.annotation.SunValid;

/**
 * @author sungp
 * @description: TODO
 * @date 2022年03月06日 21:27
 */
public interface SunValidHandler<T> {

    /**
     * @description: 实际的校验方法
     * @author sungp
     * @date 2022年03月06日 21:37
     * @param sunValid 注解
     * @param data 校验的数据
     * @return boolean
     */
    boolean valid(SunValid sunValid , T data);

}
