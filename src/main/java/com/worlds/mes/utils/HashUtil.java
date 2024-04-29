package com.worlds.mes.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {
    public static String hash(String password) {
        try {
            // 创建MessageDigest对象，指定使用MD5算法
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 将密码转换为byte数组
            byte[] passwordBytes = password.getBytes();
            // 使用指定的byte数组更新摘要
            md.update(passwordBytes);
            // 获取摘要的字节数组
            byte[] digest = md.digest();
            // 将字节数组转换为十六进制字符串
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    //验证密码
    public static boolean verify(String password, String hashedPassword) {
        // 对输入的密码进行加密
        String encryptedPassword = hash(password);
        // 验证加密后的密码与哈希值是否相等
        return hashedPassword.equals(encryptedPassword);
    }

    public static void main(String[] args) {
        String password = "password";
        // 对密码进行哈希加密
        String hashedPassword = hash(password);
        System.out.println("哈希值：" + hashedPassword);

        // 验证密码
        boolean result = verify(password, hashedPassword);
        System.out.println("验证结果：" + result);
    }
}
