/*
 * 文件名：Espresso.java
 * 版权：卫士通移动事业部
 * 描述：具体的饮料类
 * 创建人：wang.li
 * 创建时间：2016年10月21日
 */
package com.westone.designmode;

/**
 * @author wang.li
 *
 *         具体的饮料类
 */
public class Espresso extends Beverage
{
    
    /*
     * (non-Javadoc)
     * 
     * @see com.westone.designmode.Beverage#getDescription()
     */
    @Override
    public String getDescription()
    {
        return "Espresso";
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see com.westone.designmode.Beverage#cost()
     */
    @Override
    public double cost()
    {
        return 1.99;
    }
    
}
