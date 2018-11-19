/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: MD5Util
 * Author:   Administrator
 * Date:     2018/11/14 21:42
 * Description: 加密工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sp.test.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈加密工具类〉
 *
 * @author Administrator
 * @create 2018/11/14
 * @since 1.0.0
 */
public class MD5Util {
    /**
     * 将元原字符串使用MD5加密
     * @param source
     * @return
     */
    public static  byte[] encode2bytes(String source ){
        byte[] result =null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(source.getBytes("UTF-8"));
            result = md.digest();


        }catch ( NoSuchAlgorithmException e){
            e.printStackTrace();

        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return result;
    }
    public  static String encode2hex(String source){
        byte[] data  = encode2bytes(source);

        StringBuffer hexString  = new StringBuffer();
        for (int i = 0; i <data.length ; i++) {
            String hex = Integer.toHexString(0xff &data[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }

            hexString.append(hex);
        }

        return hexString.toString();


    }
    public static boolean validate(String unknown , String okHex) {
        return okHex.equals(encode2hex(unknown));
    }


}

