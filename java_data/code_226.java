package com.youlan.common.crypto.anno;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.youlan.common.crypto.enums.AlgorithmType;
import com.youlan.common.crypto.jackson.DecryptFiledDeserializer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@JacksonAnnotationsInside
@JsonDeserialize(using = DecryptFiledDeserializer.class)
public @interface DecryptField {
    
    AlgorithmType algorithm() default AlgorithmType.AES;

    
    String key() default StrUtil.EMPTY;

    
    String publicKey() default StrUtil.EMPTY;

    
    String privateKey() default StrUtil.EMPTY;

    
    KeyType decryptKeyType() default KeyType.PrivateKey;
}