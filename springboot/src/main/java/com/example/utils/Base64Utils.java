package com.example.utils;

import cn.hutool.core.codec.Base64;

public class Base64Utils {
    //base64字符串加密方法
    public static String encode(String str) {
        return Base64.encode(str);
    }

    //base64字符串解密方法
    public static String decode(String str) {
        return Base64.decodeStr(str);
    }

}
