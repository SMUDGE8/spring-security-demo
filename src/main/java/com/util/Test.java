package com.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author lei
 * @since 2018/1/31
 */
public class Test {

    public static void main(String[] args) {
        String pass = "1";
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        String hashPass = encode.encode(pass);
        System.out.println(hashPass);
    }
}
