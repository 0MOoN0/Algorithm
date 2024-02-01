package com.demos.crypto;

import cn.hutool.crypto.SecureUtil;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        String encrypt = main.encrypt("1234", "4321");
        System.out.println(encrypt);
        String decrypt = main.decrypt("1234", "");
        System.out.println(decrypt);
    }

    public String encrypt(String key, String data){
        String s = SecureUtil.md5(key);
        byte[] encrypt = SecureUtil.aes(s.getBytes(StandardCharsets.UTF_8)).encrypt(data, StandardCharsets.UTF_8);
        return Base64.getEncoder().encodeToString(encrypt);
    }

    public String decrypt(String key, String ciphertext){
        byte[] decode = Base64.getDecoder().decode(ciphertext);
        String s = SecureUtil.md5(key);
        byte[] decrypt = SecureUtil.aes(s.getBytes(StandardCharsets.UTF_8)).decrypt(decode);
        return new String(decrypt, StandardCharsets.UTF_8);
    }

}
