package com.roncoo.jui.web.bean.qo;



import java.io.Serializable;

import java.util.Date;



import lombok.Data;

import lombok.experimental.Accessors;





@Data

@Accessors(chain = true)

public class WebSiteUrlQO implements Serializable {



    private static final long serialVersionUID = 1L;



    private Long id;

    

    private Date gmtCreate;

    

    private Date gmtModified;

    

    private String statusId;

    

    private Integer sort;

    private Long siteId;

    

    private String urlName;

    

    private String urlDesc;

    

    private String inNet;

    

    private String outNet;

}