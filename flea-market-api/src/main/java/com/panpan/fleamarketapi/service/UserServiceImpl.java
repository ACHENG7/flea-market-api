package com.panpan.fleamarketapi.service;

import com.panpan.fleamarketapi.common.Constant;
import com.panpan.fleamarketapi.domain.User;
import com.panpan.fleamarketapi.mapper.UserMapper;
import com.panpan.fleamarketapi.util.EmailUtil;
import com.panpan.fleamarketapi.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import net.sf.json.JSONObject;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Log4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private StringRedisTemplate redisTemplate;
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public Boolean sendEmail(String email, String key) {
        Boolean result = false;
        try {
            InetAddress address = InetAddress.getLocalHost();
            String host = address.getHostAddress();
            String title = "(๑•̀ㅂ•́)و✧欢迎注册校园闲置转售账号";
            StringBuilder content = new StringBuilder("可爱的同学～你好呀\n点击以下链接就可以完成注册了吼～\n\n");
            content.append("http://" + host + "/user/activate?key=");
            content.append(key);
            new EmailUtil().send(email, title, content.toString());
            result = true;
        } catch (Exception e) {
            log.error("sendEmail======fail!======[receiver: " + email + "]");
            log.error(ExceptionUtils.getStackTrace(e));
        } finally {
            return result;
        }
    }

    @Override
    public String saveRegisterKey(String userInfo) {
        String key = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(Constant.REGISTER_KEY + "_" + key, userInfo, 2, TimeUnit.HOURS);
        return key;
    }

    @Override
    public Boolean activateUser(String key) {
        String userInfo = redisTemplate.opsForValue().get(Constant.REGISTER_KEY + "_" + key);
        if (!Strings.isNotEmpty(userInfo)) {
            User user = (User) JSONObject.toBean(JsonUtil.toJSon(userInfo), User.class);
            if (user != null) {
                userMapper.saveUser(user);
                redisTemplate.delete(Constant.REGISTER_KEY + "_" + key);
                return true;
            }
        }
        return false;
    }
}
