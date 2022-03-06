package com.sungp.core.web.exception;

import com.sungp.core.result.ResultMessage;
import com.sungp.core.web.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author sungp
 * @description: 全局异常处理
 * @date 2022年03月06日 11:05
 */
@Slf4j
@RestControllerAdvice
public class GlobalException {

    /**
     * @description: 参数校验统一异常处理
     * @author sungp
     * @date 2022年03月06日 21:22
     * @param exception 异常
     * @return ResultMessage<Set<String>>
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultMessage<Set<String>> methodArgumentNotValidException(MethodArgumentNotValidException exception) {

        //获得绑定的返回对象
        BindingResult result = exception.getBindingResult();

        Set<String> set = result.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toSet());

        log.error("[MethodArgumentNotValid - Exception] - 捕获到参数校验异常！", exception);
        return ResultMessage.createParameterError(set);
    }

    /**
     * @description: 自定义业务异常处理
     * @author sungp
     * @date 2022年03月06日 21:18
     * @param exception 异常
     * @return ResultMessage<String>
     */
    @ExceptionHandler(ServiceException.class)
    public ResultMessage<String> serviceExceptionHandler(ServiceException exception) {
        log.error("[Service - Exception] - 捕获到业务异常信息！", exception);
        return ResultMessage.create(exception.getCode() , exception.getMessage() , exception.toString());
    }

    @ExceptionHandler
    public ResultMessage<String> globalExceptionHandler(Throwable throwable) {
        log.error("[Global - Exception] - 捕获到全局异常！");

        //获取异常请求的信息
        HttpServletRequest request = HttpUtils.getRequest();

        String url = request.getRequestURL().toString();
        log.error("[Global - Exception] - 请求的url - {}", url);

        log.error("[Global - Exception] - 异常信息", throwable);

        return ResultMessage.createServerException(throwable.toString());
    }

}
