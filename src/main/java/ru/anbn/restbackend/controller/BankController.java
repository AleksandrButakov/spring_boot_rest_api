package ru.anbn.restbackend.controller;

import jdk.jfr.Label;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.anbn.restbackend.domain.LoginInfo;
import ru.anbn.restbackend.domain.UserInfo;
import ru.anbn.restbackend.exception.InvalidUserNameException;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class BankController {

    Map<String, UserInfo> users = Map.of(
            "Dima", UserInfo.builder().userName("Dima").build(),
            "Masha", UserInfo.builder().userName("Masha").build(),
            "Ivan", UserInfo.builder().userName("Ivan").build()
    );

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

    @GetMapping("user/getAll")
    public List<UserInfo> getAllUserInfo() {
        return users.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

}