package ru.anbn.restbackend.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.anbn.restbackend.domain.LoginInfo;
import ru.anbn.restbackend.domain.UserInfo;
import ru.anbn.restbackend.exception.InvalidUserNameException;

import java.util.Date;

@RestController
public class BankController {

    @PostMapping("user/login")
    public UserInfo doLogin(@RequestBody LoginInfo loginInfo) {
        if (loginInfo.getUserName().equals("Dima")) {
            return UserInfo.builder()
                    .loginDate(String.valueOf(new Date()))
                    .userName(loginInfo.getUserName())
                    .build();
        } else {
            throw new InvalidUserNameException();
        }

    }
}