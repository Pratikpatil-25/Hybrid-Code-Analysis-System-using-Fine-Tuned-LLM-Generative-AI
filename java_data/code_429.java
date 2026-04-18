package org.berlingroup.security.model;


public enum DigestAlgorithm {

    SHA_256("SHA-256"),
    SHA_512("SHA-512");

    private final String headerPrefix;

    DigestAlgorithm(String headerPrefix) {
        this.headerPrefix = headerPrefix;
    }

    
    public String getHeaderPrefix() {
        return headerPrefix;
    }

    
    public String getJavaAlgorithmName() {
        return headerPrefix;     }

    public static DigestAlgorithm fromHeaderPrefix(String prefix) {
        for (DigestAlgorithm alg : values()) {
            if (alg.headerPrefix.equalsIgnoreCase(prefix)) {
                return alg;
            }
        }
        throw new IllegalArgumentException("Unsupported digest algorithm: " + prefix);
    }
}