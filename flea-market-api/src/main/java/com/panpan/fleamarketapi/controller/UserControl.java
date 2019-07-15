package com.panpan.fleamarketapi.controller;

import com.panpan.fleamarketapi.Result.ResultGenerator;
import com.panpan.fleamarketapi.domain.User;
import com.panpan.fleamarketapi.service.UserService;
import com.panpan.fleamarketapi.util.JsonUtil;
import lombok.AllArgsConstructor;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("user")
public class UserControl {
    private UserService userService;

    @GetMapping("/test")
    public String test() {
        return JsonUtil.toJSonArrStr(userService.getAllUser());
    }

    @PostMapping("/register")
    public String register(String userInfo) {
        User user = (User) JSONObject.toBean(JsonUtil.toJSon(userInfo), User.class);
        String email = user.getEmail();
        //发送邮箱
        String key = userService.saveRegisterKey(userInfo);
        if (userService.sendEmail(email, key)) {
            return JsonUtil.toJSonStr(ResultGenerator.getSuccessResult());
        }
        return JsonUtil.toJSonStr(ResultGenerator.getFailResult("注册失败！请重新填写信息"));
    }

    @GetMapping("/activate")
    public String activate(String key){
        if(userService.activateUser(key)){
            return JsonUtil.toJSonStr(ResultGenerator.getSuccessResult());
        }
        return JsonUtil.toJSonStr(ResultGenerator.getFailResult("激活账号失败！请重新注册"));
    }

}
