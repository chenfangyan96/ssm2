/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: EnctryptPropertyPlaceholderConfigurer
 * Author:   Administrator
 * Date:     2018/11/19 14:26
 * Description: 对properties进行加密
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sp.test.util;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 〈一句话功能简述〉<br> 
 * 〈对properties进行加密〉
 *
 * @author Administrator
 * @create 2018/11/19
 * @since 1.0.0
 */
public class EntryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    //定义解密的属性
    private  String [] propertyValues ={"jdbc.username","jdbc.password"};
    private  static String srcKey="AaDdFf";
    private boolean isEnctryptPropertyValue(String value){

        for(String propertyValue:propertyValues) {
            if(propertyValue.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        System.out.println(propertyName+" "+propertyValue);
        if (isEnctryptPropertyValue(propertyName)){
            String decryResult =null;
            try {
                decryResult =AESUtil.decrypt(propertyValue,srcKey);

            }catch (Exception e1){

                e1.printStackTrace();

            }
            //返回解密后的属性值
            return  decryResult;
            }
            return propertyValue;

    }
}

