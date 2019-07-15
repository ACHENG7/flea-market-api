package com.panpan.fleamarketapi.controller;

import com.panpan.fleamarketapi.domain.User;
import com.panpan.fleamarketapi.Result.ResultGenerator;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class controller {
    @RequestMapping("/")
    String test(){
        User user = new User();
        user.setId(1);
//        user.setAge(18);
//        user.setName("test");
        return JSONObject.fromObject(ResultGenerator.getSuccessResult(user)).toString();
    }
}
