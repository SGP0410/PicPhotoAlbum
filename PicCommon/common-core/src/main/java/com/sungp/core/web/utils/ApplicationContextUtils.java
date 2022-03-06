package com.sungp.core.web.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @author sungp
 * @description: Spring容器的工具方法 -- 手动从spring中获取bean对象
 * @date 2022年03月06日 20:55
 */
public class ApplicationContextUtils {

    @Autowired
    private ApplicationContext applicationContext;

    private static ApplicationContext staticApplicationContext;


    /**
     * @description: 初始化方法
     * @author sungp
     * @date 2022年03月06日 21:00
     * @return void
     */
    @PostConstruct
    public void init(){
        ApplicationContextUtils.staticApplicationContext = applicationContext;
    }

    /**
     * @description: 根据class类型获取spring容器中的对象
     * @author sungp
     * @date 2022年03月06日 21:01
     * @param clazz 要获取类的类型
     * @return T 返回的对象
     */
    public static <T> T getBean(Class<T> clazz){
        if (staticApplicationContext != null)
            return staticApplicationContext.getBean(clazz);
        return null;
    }

}
