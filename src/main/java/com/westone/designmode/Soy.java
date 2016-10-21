/*
 * 文件名：Soy.java
 * 版权：卫士通移动事业部
 * 描述：一种调料
 * 创建人：wang.li
 * 创建时间：2016年10月21日
 */
package com.westone.designmode;

/**
 * @author wang.li
 *
 *         一种调料
 */
public class Soy extends CondimentDecorator
{
    
    private Beverage beverage;
    
    /**
     * @param beverage
     */
    public Soy(Beverage beverage)
    {
        this.beverage = beverage;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see com.westone.designmode.CondimentDecorator#getDescription()
     */
    @Override
    public String getDescription()
    {
        return beverage.getDescription() + ",soy";
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see com.westone.designmode.Beverage#cost()
     */
    @Override
    public double cost()
    {
        return beverage.cost() + 1.05;
    }
    
}
