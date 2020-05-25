package com.muxiao.xuexiquan.gateway.modular.auth.util;

import com.muxiao.xuexiquan.gateway.config.properties.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenUtil {

    @Autowired
    private JwtProperties jwtProperties;

    public String generateToken(String userName, String randomKey) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(jwtProperties.getRandomKey(),randomKey);
        return doGenerateToken(claims, userName);
    }

    private String doGenerateToken(Map<String,Object> claims, String subject){
        final Date createdDate = new Date();
        final Date expiratoinDate = new Date(createdDate.getTime() + jwtProperties.getExpiration() * 1000);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(createdDate)
                .setExpiration(expiratoinDate)
                .signWith(SignatureAlgorithm.HS512,jwtProperties.getSecrect())
                .compact();
    }

    public Claims getClaimFromToken(String token) {
        return  Jwts.parser()
                .setSigningKey(jwtProperties.getSecrect())
                .parseClaimsJws(token)
                .getBody();
    }

    public String getUserNameFromToken(String token) {
        return getClaimFromToken(token).getSubject();
    }
    /**
     * 获取jwt发布时间
     */
    public Date getIssuedAtDateFromToken(String token) {
        return getClaimFromToken(token).getIssuedAt();
    }

    /**
     * 获取jwt失效时间
     */
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token).getExpiration();
    }
}
