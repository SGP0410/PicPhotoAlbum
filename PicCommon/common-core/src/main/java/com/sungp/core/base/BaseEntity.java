package com.sungp.core.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author sungp
 * @description: 基础实体类
 * @date 2022年03月05日 20:04
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * id
     */
    private String id;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 更新时间
     */
    private Long updateTime;
    /**
     * 是否删除
     */
    private Boolean isDeleted;
    
}
