/*
 * 文件名：Beverage.java
 * 版权：卫士通移动事业部
 * 描述：装饰着模式，饮料抽象类
 * 创建人：wang.li
 * 创建时间：2016年10月21日
 */
package com.westone.designmode;

/**
 * @author wang.li
 *
 *         装饰着模式，饮料抽象类
 */
public abstract class Beverage
{
    protected String description;
    
    /**
     * 饮料描述
     * 
     * @return
     */
    public abstract String getDescription();
    
    /**
     * 饮料价格
     * 
     * @return
     */
    public abstract double cost();
}
