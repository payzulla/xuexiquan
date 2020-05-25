package com.muxiao.xuexiquan.gateway.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = RestProperties.REST_PREFIX)
public class RestProperties {

    public static final String REST_PREFIX = "rest";

    private boolean authOpen = true;

    private boolean signOpen = true;


}
