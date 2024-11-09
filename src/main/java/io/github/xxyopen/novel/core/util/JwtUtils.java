package io.github.xxyopen.novel.core.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * JWT Utility Class
 */
@ConditionalOnProperty("novel.jwt.secret")
@Component
@Slf4j
public class JwtUtils {

    /**
     * Inject JWT encryption secret
     */
    @Value("${novel.jwt.secret}")
    private String secret;

    /**
     * Define the system identifier header constant
     */
    private static final String HEADER_SYSTEM_KEY = "systemKeyHeader";

    /**
     * Generate JWT based on user ID
     *
     * @param uid       User ID
     * @param systemKey System identifier
     * @return JWT
     */
    public String generateToken(Long uid, String systemKey) {
        return Jwts.builder()
                .setHeaderParam(HEADER_SYSTEM_KEY, systemKey)
                .setSubject(uid.toString())
                .signWith(Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)))
                .compact();
    }

    /**
     * Parse JWT and return user ID
     *
     * @param token     JWT
     * @param systemKey System identifier
     * @return User ID
     */
    public Long parseToken(String token, String systemKey) {
        Jws<Claims> claimsJws;
        try {
            claimsJws = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)))
                    .build()
                    .parseClaimsJws(token);
            // OK, we can trust this JWT
            // Check if the JWT belongs to the specified system
            if (Objects.equals(claimsJws.getHeader().get(HEADER_SYSTEM_KEY), systemKey)) {
                return Long.parseLong(claimsJws.getBody().getSubject());
            }
        } catch (JwtException e) {
            log.warn("JWT parsing failed: {}", token);
            // Don't trust the JWT!
        }
        return null;
    }

}
