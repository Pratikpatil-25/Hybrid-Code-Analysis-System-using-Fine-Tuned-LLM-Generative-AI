package com.itextpdf.signatures;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;


public class ProviderDigest implements IExternalDigest {
    private String provider;

    
    public ProviderDigest(String provider) {
        this.provider = provider;
    }

    @Override
    public MessageDigest getMessageDigest(String hashAlgorithm) throws GeneralSecurityException{
        return DigestAlgorithms.getMessageDigest(hashAlgorithm, provider);
    }
}