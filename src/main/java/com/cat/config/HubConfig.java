package com.cat.config;

import java.math.BigDecimal;

/**
 * Created by 周杰伦 on 2018/1/15.
 */
// 内部类，内部代码，静态变量，静态代码练习
public class HubConfig {

    BigDecimal bigDecimal = new BigDecimal(11);
    {
        name = "mayun";
        System.out.print(name);
    }

    static String name = "liyanhong";
    static {
        name = "dinglei";
        System.out.print(name);
    }

    public HubConfig(){
        System.out.print(name);
    }
    private enum ceoName{

    }
    private static class InnerConfig{
        static String userName = "mahuateng";
    }
    public static void ceoSpeak(){
        System.out.print(InnerConfig.userName);
    }
    public static void ctoSpeak(){
        System.out.print(InnerConfig.userName);
    }

    public static void main(String args[]) {
        HubConfig hubConfig = new HubConfig();
        hubConfig.ceoSpeak();


    }
}
