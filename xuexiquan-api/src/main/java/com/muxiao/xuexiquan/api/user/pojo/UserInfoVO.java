package com.muxiao.xuexiquan.api.user.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class UserInfoVO {
    private String username;
    private String email;
    private String address;
    private String city;
    private String schoolName;
    private String sext;
    private String major;
}
