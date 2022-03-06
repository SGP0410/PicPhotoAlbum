package com.sungp.core.web.valid.constraint;

import com.sungp.core.web.utils.ApplicationContextUtils;
import com.sungp.core.web.valid.annotation.SunValid;
import com.sungp.core.web.valid.handler.SunValidHandler;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

/**
 * @author sungp
 * @description: TODO
 * @date 2022年03月06日 21:27
 */
public class SunValidConstraint implements ConstraintValidator<SunValid , Object> {

    private SunValid sunValid;

    @Override
    public void initialize(SunValid constraintAnnotation) {
        this.sunValid = constraintAnnotation;
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        //判断非空
        if (value != null){
            //交给SunValidHandler实现类处理
            SunValidHandler sunValidHandler = ApplicationContextUtils.getBean(sunValid.handler());
            return Optional.ofNullable(sunValidHandler)
                    .map(sunValidHandler1 -> {
                        return sunValidHandler.valid(sunValid , value);
                    }).orElse(false);
        }
        //数据为空则通过校验，校验非空由@NotNull来做
        return true;
    }
}
