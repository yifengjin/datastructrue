/*
 * 文件名：HouseBlend.java
 * 版权：卫士通移动事业部
 * 描述：TODO(用一句话描述该文件做什么)
 * 创建人：wang.li
 * 创建时间：2016年10月21日
 */
package com.westone.designmode;

/**
 * @author wang.li
 *
 *         一句话描述该类型的作用
 */
public class HouseBlend extends Beverage
{
    
    /*
     * (non-Javadoc)
     * 
     * @see com.westone.designmode.Beverage#getDescription()
     */
    @Override
    public String getDescription()
    {
        return "HouseBlend";
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see com.westone.designmode.Beverage#cost()
     */
    @Override
    public double cost()
    {
        return 0.89;
    }
    
}
