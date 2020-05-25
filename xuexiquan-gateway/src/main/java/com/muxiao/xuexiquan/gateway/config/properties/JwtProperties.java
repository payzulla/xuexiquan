package com.muxiao.xuexiquan.gateway.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = JwtProperties.JTW_PREFIX)
public class JwtProperties {

    public static final String JTW_PREFIX = "jwt";

    private String header = "Authorizatoin";

    private String secrect = "defaultSecret";

    private Long expiration = 604800L;

    private String authPath = "auth";

    private String ignoreUrl = "";

    private String randomKey = "randomKey";

}
