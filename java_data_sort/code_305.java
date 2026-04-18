package com.seahorse.youliao.vo.response.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@ToString
public class TreeData {

    
    private String key;

    
    private Integer value;

    
    private String title;

    
    private Integer pid;

    
    private Integer sort;

    public TreeData(String key, Integer value, String title, Integer pid, Integer sort) {
        this.key = key;
        this.value = value;
        this.title = title;
        this.pid = pid;
        this.sort = sort;
    }

    private List<TreeData> children;
}