package com.tianji.auth.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyPair;
import java.util.Base64;

@Hidden
@RestController
@RequestMapping("jwks")
public class JwkController {

    private final KeyPair keyPair;

    public JwkController(KeyPair keyPair) {
        this.keyPair = keyPair;
    }

    @GetMapping
    public String getJwk() {
        // TODO 可以加入clientId和clientSecret校验
        // 获取公钥并转码
        return Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
    }
}
