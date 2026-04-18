package com.zhisida.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.zhisida.core.pojo.base.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_role")
public class SysRole extends BaseEntity {

    
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    
    private String name;

    
    private String code;

    
    private Integer sort;

    
    private Integer dataScopeType;

    
    @TableField(insertStrategy = FieldStrategy.IGNORED, updateStrategy = FieldStrategy.IGNORED)
    private String remark;

    
    private Integer status;
}