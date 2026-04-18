package com.zy.blog.view;


import com.zy.blog.base.ViewBase;
import com.zy.blog.utils.annotion.validator.annotion.IntegerNotNull;
import com.zy.blog.utils.annotion.validator.annotion.NotBlank;
import com.zy.blog.utils.annotion.validator.group.*;
import lombok.Data;


@Data
public class SysDictDataView extends ViewBase<SysDictDataView> {


    
    private Long oid;

    
    @NotBlank(groups = {Insert.class, Update.class})
    private String dictLabel;

    
    @NotBlank(groups = {Insert.class, Update.class})
    private String dictValue;

    
    @NotBlank(groups = {Insert.class, Update.class})
    private String dictTypeUid;

    
    private String cssClass;

    
    private String listClass;

    
    @IntegerNotNull(groups = {Insert.class, Update.class})
    private Integer isDefault;

    
    @NotBlank(groups = {Insert.class, Update.class})
    private String isPublish;

    
    private String remark;

    
    @IntegerNotNull(groups = {Insert.class, Update.class})
    private Integer sort;

}