/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Test
 * Author:   Administrator
 * Date:     2018/11/6 9:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.io.UnsupportedEncodingException;


/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2018/11/6
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) {
       String str = new String("hell");
       byte [] bt = null;
       try{
       bt = str.getBytes("utf-8");

       }catch(UnsupportedEncodingException e){
           e.printStackTrace();

       }
        for (int i = 0; i < bt.length; i++) {
            System.out.println(bt[i]);

        }
    }

    }
    class hello extends Thread{
        @Override
        public void run() {

            for(int i=0;i<10000;i++) {
                System.out.println(i+"000");
                try {
                    Thread.sleep(20);
                }catch (InterruptedException e){

                }
            }
        }
    }
    class nihao extends Thread{
        @Override
        public void run() {

            for(int i=0;i<10000;i++) {
                System.out.println(i+"###");
                try {
                    Thread.sleep(20);
                }catch (InterruptedException e){

                }
            }

        }
}

