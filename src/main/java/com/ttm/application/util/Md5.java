package com.ttm.application.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <p>@Author tangtaiming</p>
 * <p>@Date 2019-07-16</p>
 * <p>@Version 1.0</p>
 **/
public class Md5 {

    private String originalString;

    public Md5(String originalString) {
        this.originalString = originalString;
    }

    public String toMD5() {
        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(this.originalString.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException arg4) {
            System.out.println("NoSuchAlgorithmException caught!");
        } catch (UnsupportedEncodingException arg5) {
//            ExceptionMessage.save(arg5);
        }

        byte[] byteArray = messageDigest.digest();
        StringBuilder md5StrBuff = new StringBuilder();

        for (int i = 0; i < byteArray.length; ++i) {
            if (Integer.toHexString(255 & byteArray[i]).length() == 1) {
                md5StrBuff.append("0").append(Integer.toHexString(255 & byteArray[i]));
            } else {
                md5StrBuff.append(Integer.toHexString(255 & byteArray[i]));
            }
        }

        return md5StrBuff.toString();
    }

}
