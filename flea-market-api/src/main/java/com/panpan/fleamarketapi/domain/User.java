package com.panpan.fleamarketapi.domain;

import lombok.Data;

@Data
public class User {
    private int id;
    private String nickname;
    private String password;
    private String student_info;
    private Integer sex;
    private String email;
    private String tel;
}
