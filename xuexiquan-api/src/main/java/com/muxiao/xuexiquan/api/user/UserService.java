package com.muxiao.xuexiquan.api.user;

public interface UserService {
    int login(String username, String password);

    boolean register();
}
