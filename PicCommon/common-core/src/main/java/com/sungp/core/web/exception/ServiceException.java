package com.sungp.core.web.exception;

import com.sungp.core.result.HttpCodes;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author sungp
 * @description: 自定义异常
 * @date 2022年03月06日 11:05
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceException extends RuntimeException{

    private String code;

    /**
     * @description: 自定义响应码异常构造
     * @author sungp
     * @date 2022年03月06日 20:49
     * @param codes 响应码
     * @return null
     */
    public ServiceException(HttpCodes codes){
        super(codes.getMsg());
        this.code = codes.getCode();
    }

    /**
     * @description: 特殊响应构造
     * @author sungp
     * @date 2022年03月06日 20:51
     * @param code 响应码
     * @param msg 消息
     * @return null
     */
    public ServiceException(String code , String msg){
        super(msg);
        this.code = code;
    }

    public ServiceException(){}

}
