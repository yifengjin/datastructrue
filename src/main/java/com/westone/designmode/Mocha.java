/*
 * 文件名：Mocha.java
 * 版权：卫士通移动事业部
 * 描述：一种调料
 * 创建人：wang.li
 * 创建时间：2016年10月21日
 */
package com.westone.designmode;

/**
 * @author wang.li
 *
 *         一种调料，装饰者
 */
public class Mocha extends CondimentDecorator
{
    private Beverage beverage;
    
    /**
     * @param beverage
     */
    public Mocha(Beverage beverage)
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
        return beverage.getDescription() + ",Mocha";
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see com.westone.designmode.Beverage#cost()
     */
    @Override
    public double cost()
    {
        return beverage.cost() + 0.20;
    }
    
}
