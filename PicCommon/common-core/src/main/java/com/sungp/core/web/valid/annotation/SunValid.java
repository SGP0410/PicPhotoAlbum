package com.sungp.core.web.valid.annotation;

import com.sungp.core.web.valid.constraint.SunValidConstraint;
import com.sungp.core.web.valid.handler.SunValidHandler;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author sungp
 * @description: 自定义参数校验注解
 * @date 2022年03月06日 21:27
 */
@Target({ElementType.FIELD , ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SunValidConstraint.class)
public @interface SunValid {

    /**
     * @description: 校验失败后的提示
     * @author sungp
     * @date 2022年03月06日 21:33
     * @return String
     */
    String message() default "校验失败";

    /**
     * @description: 校验的分组
     * @author sungp
     * @date 2022年03月06日 21:33  
     * @return Class<?>
     */
    Class<?>[] groups() default {};

    /**
     * @description: 校验的负载
     * @author sungp
     * @date 2022年03月06日 21:33  
     * @return Class<Payload>
     */
    Class<? extends Payload>[] payload() default {};

    /**
     * @description: 实际校验处理的class对象
     * @author sungp
     * @date 2022年03月06日 21:34
     * @return Class<SunValidHandler<?>>
     */
    Class<? extends SunValidHandler<?>> handler();




}
