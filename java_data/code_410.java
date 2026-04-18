package com.coinbase.cdp.auth;

import com.coinbase.cdp.auth.exceptions.JwtGenerationException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SignatureAlgorithm;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class JwtGenerator {

  private static final SecureRandom SECURE_RANDOM = new SecureRandom();

  private JwtGenerator() {}

  
  public static String generateJwt(JwtOptions options) {
    try {
      PrivateKey privateKey = KeyParser.parsePrivateKey(options.keySecret());
      SignatureAlgorithm algorithm = determineAlgorithm(privateKey);

      long now = Instant.now().getEpochSecond();
      long expiresIn = options.getEffectiveExpiresIn();

      Map<String, Object> header = new HashMap<>();
      header.put("alg", algorithm.getId());
      header.put("kid", options.keyId());
      header.put("typ", "JWT");
      header.put("nonce", generateNonce());

      var builder =
          Jwts.builder()
              .header()
              .add(header)
              .and()
              .subject(options.keyId())
              .issuer("cdp")
              .issuedAt(Date.from(Instant.ofEpochSecond(now)))
              .notBefore(Date.from(Instant.ofEpochSecond(now)))
              .expiration(Date.from(Instant.ofEpochSecond(now + expiresIn)));

            options.audience().ifPresent(aud -> builder.claim("aud", aud));

            if (options.isRestRequest()) {
        String uri =
            String.format(
                "%s %s%s", options.requestMethod(), options.requestHost(), options.requestPath());
        builder.claim("uris", List.of(uri));
      }

      return builder.signWith(privateKey, algorithm).compact();

    } catch (JwtGenerationException e) {
      throw e;
    } catch (Exception e) {
      throw new JwtGenerationException("Failed to generate JWT: " + e.getMessage(), e);
    }
  }

  private static SignatureAlgorithm determineAlgorithm(PrivateKey key) {
    if (KeyParser.isEcKey(key)) {
      return Jwts.SIG.ES256;
    } else if (KeyParser.isEd25519Key(key)) {
      return Jwts.SIG.EdDSA;
    } else {
      throw new JwtGenerationException("Unsupported key algorithm: " + key.getAlgorithm());
    }
  }

  private static String generateNonce() {
    byte[] bytes = new byte[16];
    SECURE_RANDOM.nextBytes(bytes);
    StringBuilder hex = new StringBuilder();
    for (byte b : bytes) {
      hex.append(String.format("%02x", b));
    }
    return hex.toString();
  }
}