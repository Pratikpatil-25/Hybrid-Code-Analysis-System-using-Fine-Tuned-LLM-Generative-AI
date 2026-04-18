package com.baidubce.services.bec.model.blb;

import com.baidubce.auth.BceCredentials;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


@Data
public class CreateBecBlbMonitorPortRequest extends BlbListenerRequest {

    
    private String blbId;

    
    @JsonIgnore
    private String clientToken;

    
    public CreateBecBlbMonitorPortRequest withRequestCredentials(BceCredentials credentials) {
        this.setRequestCredentials(credentials);
        return this;
    }
}