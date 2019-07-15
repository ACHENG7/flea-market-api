package com.panpan.fleamarketapi.mapper;

import com.panpan.fleamarketapi.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {
    List<User> getAllUser();
    void saveUser(User user);
}
