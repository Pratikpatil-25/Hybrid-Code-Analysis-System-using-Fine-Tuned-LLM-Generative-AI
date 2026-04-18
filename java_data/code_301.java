package com.lanternfish.common.encrypt;

import com.lanternfish.common.enums.AlgorithmType;
import com.lanternfish.common.enums.EncodeType;
import lombok.Data;


@Data
public class EncryptContext {

    
    private AlgorithmType algorithm;

    
    private String password;

    
    private String publicKey;

    
    private String privateKey;

    
    private EncodeType encode;

}