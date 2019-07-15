package com.panpan.fleamarketapi.service;

import com.panpan.fleamarketapi.domain.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    Boolean sendEmail(String email, String key);

    String saveRegisterKey(String userInfo);

    Boolean activateUser(String key);
}
