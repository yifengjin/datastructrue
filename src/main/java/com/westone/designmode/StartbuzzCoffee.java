/*
 * 文件名：StartbuzzCoffee.java
 * 版权：卫士通移动事业部
 * 描述：TODO(用一句话描述该文件做什么)
 * 创建人：wang.li
 * 创建时间：2016年10月21日
 */
package com.westone.designmode;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author wang.li
 *
 *         一句话描述该类型的作用
 */
public class StartbuzzCoffee
{
    public static void main(String[] args)
    {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription());
        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        System.out.println(beverage.getDescription() + ",$" + beverage.cost());
        File file = new File("hello.txt");
        FileInputStream in = null;
        try
        {
            in = new FileInputStream(file);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        BufferedInputStream inBuffered = new BufferedInputStream(in);
    }
}
